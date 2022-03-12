package com.dag.hocam.model.mapper;

import com.dag.hocam.model.dto.QuestionDto;
import com.dag.hocam.model.entity.Question;
import com.dag.hocam.model.request.question.CreateQuestionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionMapper QUESTION_MAPPER = Mappers.getMapper(QuestionMapper.class);

    QuestionDto convertToQuestionDto(Question question);

    Question createQuestion(CreateQuestionRequest createQuestionRequest);

    List<QuestionDto> convertToQuestionDtoList(List<Question> questions);

    void updateQuestion(@MappingTarget Question question,CreateQuestionRequest createQuestionRequest);
}
