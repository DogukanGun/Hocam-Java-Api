package com.dag.hocam.service;


import com.dag.hocam.model.dto.CompletedQuizDto;
import com.dag.hocam.model.entity.CompletedQuiz;
import com.dag.hocam.model.request.completedQuiz.CreateCompletedQuizRequest;
import com.dag.hocam.repository.CompletedQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.dag.hocam.model.mapper.CompletedQuizMapper.COMPLETED_QUIZ_MAPPER;

@Service
@RequiredArgsConstructor
public class CompletedQuizService {

    private final CompletedQuizRepository completedQuizRepository;

    public CompletedQuizDto completedQuiz(CreateCompletedQuizRequest createCompletedQuizRequest){
        CompletedQuiz completedQuiz = COMPLETED_QUIZ_MAPPER.createCompletedQuiz(createCompletedQuizRequest);
        return COMPLETED_QUIZ_MAPPER.convertToCompletedQuizDto(completedQuizRepository.save(completedQuiz));
    }
}
