package com.dag.hocam.model.mapper;

import com.dag.hocam.model.dto.CompletedQuizDto;
import com.dag.hocam.model.entity.CompletedQuiz;
import com.dag.hocam.model.request.completedQuiz.CreateCompletedQuizRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompletedQuizMapper {

    CompletedQuizMapper COMPLETED_QUIZ_MAPPER = Mappers.getMapper(CompletedQuizMapper.class);

    CompletedQuiz createCompletedQuiz(CreateCompletedQuizRequest createCompletedQuizRequest);

    CompletedQuizDto convertToCompletedQuizDto(CompletedQuiz completedQuiz);
}
