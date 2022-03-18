package com.dag.hocam.service;


import com.dag.hocam.model.dto.CompletedQuizDto;
import com.dag.hocam.model.entity.CompletedQuiz;
import com.dag.hocam.model.entity.User;
import com.dag.hocam.model.request.completedQuiz.CreateCompletedQuizRequest;
import com.dag.hocam.repository.CompletedQuizRepository;
import com.dag.hocam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.hocam.model.mapper.CompletedQuizMapper.COMPLETED_QUIZ_MAPPER;

@Service
@RequiredArgsConstructor
public class CompletedQuizService {

    private final UserRepository userRepository;
    private final CompletedQuizRepository completedQuizRepository;

    public CompletedQuizDto completedQuiz(CreateCompletedQuizRequest createCompletedQuizRequest){
        User user = userRepository.findByUsernameEquals(createCompletedQuizRequest.getUsername())
                .orElseThrow(()->new NotFoundException("User Not Found"));
        CompletedQuiz completedQuiz = CompletedQuiz.builder()
                .quizId(createCompletedQuizRequest.getQuizId())
                .userId(user.getId())
                .build();
        return COMPLETED_QUIZ_MAPPER.convertToCompletedQuizDto(completedQuizRepository.save(completedQuiz));
    }
}
