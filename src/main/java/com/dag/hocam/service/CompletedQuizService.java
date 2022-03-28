package com.dag.hocam.service;


import com.dag.hocam.model.dto.CompletedQuizDto;
import com.dag.hocam.model.dto.QuestionDto;
import com.dag.hocam.model.entity.CompletedQuestion;
import com.dag.hocam.model.entity.CompletedQuiz;
import com.dag.hocam.model.entity.Quiz;
import com.dag.hocam.model.entity.User;
import com.dag.hocam.model.request.completedQuiz.CreateCompletedQuizRequest;
import com.dag.hocam.repository.CompletedQuestionRepository;
import com.dag.hocam.repository.CompletedQuizRepository;
import com.dag.hocam.repository.QuizRepository;
import com.dag.hocam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static com.dag.hocam.model.mapper.CompletedQuizMapper.COMPLETED_QUIZ_MAPPER;

@Service
@RequiredArgsConstructor
public class CompletedQuizService {

    private final UserRepository userRepository;
    private final CompletedQuizRepository completedQuizRepository;
    private final CompletedQuestionRepository completedQuestionRepository;
    private final QuizRepository quizRepository;

    @Transactional
    public CompletedQuizDto completedQuiz(CreateCompletedQuizRequest createCompletedQuizRequest){
        User user = userRepository.findByUsernameEquals(createCompletedQuizRequest.getUsername())
                .orElseThrow(()->new NotFoundException("User Not Found"));
        for (Integer integer :
                createCompletedQuizRequest.getQuestionDtoList()) {
            CompletedQuestion completedQuestion = CompletedQuestion.builder()
                    .quizId(createCompletedQuizRequest.getQuizId())
                    .userId(user.getId())
                    .questionId(integer)
                    .build();
            completedQuestionRepository.save(completedQuestion);
        }
        CompletedQuiz completedQuiz = CompletedQuiz.builder()
                .quizId(createCompletedQuizRequest.getQuizId())
                .point(createCompletedQuizRequest.getPoint())
                .userId(user.getId())
                .build();
        return COMPLETED_QUIZ_MAPPER.convertToCompletedQuizDto(completedQuizRepository.save(completedQuiz));
    }

    @Transactional
    public List<CompletedQuizDto> getCompletedQuizzes(String username){
        User user = userRepository.findByUsernameEquals(username)
                .orElseThrow(()->new NotFoundException("User Not Found"));
        List<CompletedQuiz> completedQuizzes = completedQuizRepository.findAllByUserId(user.getId());
        List<CompletedQuizDto> quizzes = new ArrayList<>();
        for (CompletedQuiz completedQuiz:
                completedQuizzes) {
            Quiz quiz = quizRepository.findAllById(completedQuiz.getQuizId()).orElseThrow(()->new NotFoundException("Quiz not found"));
            CompletedQuizDto completedQuizDto = COMPLETED_QUIZ_MAPPER.convertToCompletedQuizDto(completedQuiz);
            completedQuizDto.setQuizName(quiz.getQuizName());
            quizzes.add(completedQuizDto);
        }
        return quizzes;
    }
}
