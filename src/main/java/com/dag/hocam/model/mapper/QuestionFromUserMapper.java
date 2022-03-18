package com.dag.hocam.model.mapper;

import com.dag.hocam.model.dto.QuestionFromUserDto;
import com.dag.hocam.model.entity.Question;
import com.dag.hocam.model.entity.QuestionFromUser;
import com.dag.hocam.model.request.questionfromuser.CreateQuestionFromUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionFromUserMapper {

    QuestionFromUserMapper QUESTION_FROM_USER_MAPPER = Mappers.getMapper(QuestionFromUserMapper.class);

    QuestionFromUserDto convertToQuestionFromUserDto(QuestionFromUser questionFromUser);

    List<QuestionFromUserDto> convertToQuestionFromUserDtoList(List<QuestionFromUser> questionFromUserList);

    QuestionFromUser createQuestionFromUser(CreateQuestionFromUserRequest createQuestionFromUserRequest);

}
