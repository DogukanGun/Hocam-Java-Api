package com.dag.hocam.service;


import com.dag.hocam.model.dto.QuestionDto;
import com.dag.hocam.model.dto.QuizDto;
import com.dag.hocam.model.entity.Question;
import com.dag.hocam.model.entity.Quiz;
import com.dag.hocam.model.enums.AnswerType;
import com.dag.hocam.model.request.question.CreateQuestionRequest;
import com.dag.hocam.model.request.question.UpdateQuestionRequest;
import com.dag.hocam.model.request.quiz.CreateQuizRequest;
import com.dag.hocam.repository.QuestionRepository;
import com.dag.hocam.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Arrays;
import java.util.List;

import static com.dag.hocam.model.mapper.QuestionMapper.QUESTION_MAPPER;
import static com.dag.hocam.model.mapper.QuizMapper.QUIZ_MAPPER;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizDto createQuiz(CreateQuizRequest createQuizRequest){
        Quiz quiz = QUIZ_MAPPER.createQuiz(createQuizRequest);
        Quiz savedQuiz = quizRepository.save(quiz);
        for (CreateQuestionRequest createQuestionRequest : createQuizRequest.getCreateQuestionRequests()) {
            createQuestionRequest.setQuizId(savedQuiz.getId());
            createQuestion(createQuestionRequest);
        }
        savedQuiz = quizRepository.findById(savedQuiz.getId()).orElseThrow(()->new NotFoundException("Quiz not found"));
        return QUIZ_MAPPER.convertToQuizDto(savedQuiz);
    }

    public List<QuestionDto> getQuestionsByQuizName(String quizName){
        Quiz quiz = quizRepository.findByQuizName(quizName).orElseThrow(()->new NotFoundException("Quiz not found"));
        List<Question> questions = quiz.getQuestions();
        return QUESTION_MAPPER.convertToQuestionDtoList(questions);
    }

    public QuestionDto createQuestion(CreateQuestionRequest createQuestionRequest){
        Question question = QUESTION_MAPPER.createQuestion(createQuestionRequest);
        return QUESTION_MAPPER.convertToQuestionDto(questionRepository.save(question));
    }

    public List<QuizDto> getAllQuizzes(){
        List<Quiz> quizzes = quizRepository.findAll();
        return QUIZ_MAPPER.convertToQuizDtoList(quizzes);
    }

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
