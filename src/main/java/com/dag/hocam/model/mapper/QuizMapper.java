package com.dag.hocam.model.mapper;


import com.dag.hocam.model.dto.QuizDto;
import com.dag.hocam.model.entity.Quiz;
import com.dag.hocam.model.request.quiz.CreateQuizRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuizMapper {

    QuizMapper QUIZ_MAPPER = Mappers.getMapper(QuizMapper.class);

    QuizDto convertToQuizDto(Quiz quiz);

    List<QuizDto> convertToQuizDtoList(List<Quiz> quizzes);

    Quiz createQuiz(CreateQuizRequest createQuizRequest);
}
