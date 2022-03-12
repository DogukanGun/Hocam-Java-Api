package com.dag.hocam.model.mapper;

import com.dag.hocam.model.dto.ExampleQuestionDto;
import com.dag.hocam.model.entity.ExampleQuestion;
import com.dag.hocam.model.request.exampleQuestion.CreateExampleQuestionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExampleQuestionMapper {

    ExampleQuestionMapper EXAMPLE_QUESTION_MAPPER = Mappers.getMapper(ExampleQuestionMapper.class);

    ExampleQuestionDto convertToExampleQuestionDto(ExampleQuestion exampleQuestion);

    List<ExampleQuestionDto> convertToExampleQuestionDtoList(List<ExampleQuestion> exampleQuestions);

    ExampleQuestion createExampleQuestion(CreateExampleQuestionRequest createExampleQuestionRequest);

}
