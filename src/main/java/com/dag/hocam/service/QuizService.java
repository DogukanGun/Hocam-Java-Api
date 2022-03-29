package com.dag.hocam.service;


import com.dag.hocam.model.dto.QuestionDto;
import com.dag.hocam.model.dto.QuizDto;
import com.dag.hocam.model.entity.*;
import com.dag.hocam.model.enums.AnswerType;
import com.dag.hocam.model.enums.QuestionLevel;
import com.dag.hocam.model.request.question.CreateQuestionRequest;
import com.dag.hocam.model.request.question.GetQuestionRequest;
import com.dag.hocam.model.request.question.UpdateQuestionRequest;
import com.dag.hocam.model.request.quiz.CreateQuizRequest;
import com.dag.hocam.model.request.quiz.GetAllQuizzesRequest;
import com.dag.hocam.repository.*;
import com.dag.hocam.sec.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.dag.hocam.model.mapper.QuestionMapper.QUESTION_MAPPER;
import static com.dag.hocam.model.mapper.QuizMapper.QUIZ_MAPPER;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AuthenticationService authenticationService;
    private final CompletedQuestionRepository completedQuestionRepository;
    private final CompletedQuizRepository completedQuizRepository;


    @Transactional
    public QuizDto createQuiz(CreateQuizRequest createQuizRequest){
        Quiz quiz = QUIZ_MAPPER.createQuiz(createQuizRequest);
        return QUIZ_MAPPER.convertToQuizDto(quizRepository.save(quiz));
    }

    @Transactional
    public List<QuestionDto> getQuestionsByQuizName(GetQuestionRequest getQuestionRequest){
        Quiz quiz = quizRepository.findByQuizName(getQuestionRequest.getQuizName()).orElseThrow(()->new NotFoundException("Quiz not found"));
        List<Question> questions = quiz.getQuestions();
        return QUESTION_MAPPER.convertToQuestionDtoList(filterQuestion(questions,getQuestionRequest.getMaxQuestionNumber()));
    }

    private List<Question> filterQuestion(List<Question> questionList,int maxQuestionNumber){
        Integer userId = authenticationService.getCurrentCustomerId();
        List<CompletedQuestion> completedQuestionList = completedQuestionRepository.findAllByUserId(userId);
        List<Question> returnedQuestions = new ArrayList<>();
        int hardCounter = 0;
        int mediumCounter = 0;
        int easyCounter = 0;
        for (Question question : questionList) {
            boolean flag;
            for (CompletedQuestion completedQuestion: completedQuestionList) {
                flag = question.getId() == completedQuestion.getQuestionId() && completedQuestion.getUserId() == userId;
                if (question.getLevel() != null){
                    if (question.getLevel().equals(QuestionLevel.MEDIUM.label)){
                        if (mediumCounter >4){
                            flag =  true;
                        }else{
                            mediumCounter+=1;
                        }
                    }
                    else if (question.getLevel().equals(QuestionLevel.HARD.label)){
                        if (hardCounter >4){
                            flag =  true;
                        }else{
                            hardCounter+=1;
                        }
                    }
                    else if (question.getLevel().equals(QuestionLevel.EASY.label)){
                        if (easyCounter >4){
                            flag =  true;
                        }else{
                            easyCounter+=1;
                        }
                    }
                }
                if (!flag){
                    returnedQuestions.add(question);
                }
                if (maxQuestionNumber != returnedQuestions.size()){
                    break;
                }
            }
        }
        return returnedQuestions;
    }

    private void checkLevel(String level){
        for (QuestionLevel questionLevel : QuestionLevel.values()) {
            if (questionLevel.label.equals(level)){
                return;
            }
        }
        throw new NotFoundException("Level not found");
    }

    @Transactional
    public List<QuestionDto> createQuestions(List<CreateQuestionRequest> createQuestionRequestList){
        List<QuestionDto> returnedQuestions = new ArrayList<>();
        for (CreateQuestionRequest createQuestionRequest:createQuestionRequestList) {
            checkLevel(createQuestionRequest.getLevel());
            // TODO: 29.03.2022 quiz ile ilişki kontrol edilmeli
            Question question = QUESTION_MAPPER.createQuestion(createQuestionRequest);
            QuestionDto questionDto = QUESTION_MAPPER.convertToQuestionDto(questionRepository.save(question));
            returnedQuestions.add(questionDto);
        }
        return returnedQuestions;
    }

    public QuestionDto createQuestion(CreateQuestionRequest createQuestionRequest){
        Question question = QUESTION_MAPPER.createQuestion(createQuestionRequest);
        return QUESTION_MAPPER.convertToQuestionDto(questionRepository.save(question));
    }

    private List<Quiz> filterQuizzes(List<Quiz> quizzes){
        Integer userId = authenticationService.getCurrentCustomerId();
        List<Quiz> notSolvedQuizzes = new ArrayList<>();
        List<CompletedQuiz> completedQuizList = completedQuizRepository.findAllByUserId(userId);
        for (Quiz quiz : quizzes) {
            boolean flag = false;
            for (CompletedQuiz completedQuiz: completedQuizList) {
                if (completedQuiz.getQuizId() == quiz.getId() && completedQuiz.getUserId() == userId){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                notSolvedQuizzes.add(quiz);
            }
        }
        return notSolvedQuizzes;
    }

    public List<QuizDto> getAllQuizzes(GetAllQuizzesRequest getAllQuizzesRequest){
        List<Quiz> quizzes = quizRepository.findAll();
        if (getAllQuizzesRequest.isQuizFilter()){
            quizzes = filterQuizzes(quizzes);
        }
        return QUIZ_MAPPER.convertToQuizDtoList(quizzes);
    }

    public List<QuizDto> getAllQuizzesByTopic(GetAllQuizzesRequest getAllQuizzesRequest){
        if (getAllQuizzesRequest.getTopicId() != null){
            List<Quiz> quizzes = quizRepository.findAllByTopicId(getAllQuizzesRequest.getTopicId()).orElseThrow(()->new NotFoundException("Quizzes not found"));
            if (getAllQuizzesRequest.isQuizFilter()){
                quizzes = filterQuizzes(quizzes);
            }
            return QUIZ_MAPPER.convertToQuizDtoList(quizzes);
        }
        throw new NotFoundException("Quiz not found");
    }



    @Transactional
    public QuestionDto updateQuestion(@NotNull UpdateQuestionRequest updateQuestionRequest){
        Question question = questionRepository.findById(updateQuestionRequest.getId())
                .orElseThrow(()->new NotFoundException("Question not found"));
        if (updateQuestionRequest.getQuizId() != null){
            question.setQuizId(updateQuestionRequest.getQuizId());
        }
        if (updateQuestionRequest.getQuestion() != null){
            question.setQuestion(updateQuestionRequest.getQuestion());
        }
        if (updateQuestionRequest.getCorrectAnswer() != null &&
                Arrays.stream(AnswerType.values())
                        .anyMatch(index -> index.label.equals(updateQuestionRequest.getCorrectAnswer()))){
            question.setCorrectAnswer(updateQuestionRequest.getCorrectAnswer());
        }
        return QUESTION_MAPPER.convertToQuestionDto(questionRepository.save(question));
    }

}
