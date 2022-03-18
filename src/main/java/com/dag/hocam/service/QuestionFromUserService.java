package com.dag.hocam.service;

import com.dag.hocam.model.dto.QuestionFromUserDto;
import com.dag.hocam.model.entity.QuestionFromUser;
import com.dag.hocam.model.request.questionfromuser.CreateQuestionFromUserRequest;
import com.dag.hocam.model.request.questionfromuser.UpdateQuestionFromUserRequest;
import com.dag.hocam.repository.QuestionFromUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.dag.hocam.model.mapper.QuestionFromUserMapper.QUESTION_FROM_USER_MAPPER;

@Service
@RequiredArgsConstructor
public class QuestionFromUserService {

    private final QuestionFromUserRepository questionFromUserRepository;

    public QuestionFromUserDto createQuestionFromUser(CreateQuestionFromUserRequest createQuestionFromUserRequest){
        QuestionFromUser questionFromUser = QUESTION_FROM_USER_MAPPER.createQuestionFromUser(createQuestionFromUserRequest);
        return QUESTION_FROM_USER_MAPPER.convertToQuestionFromUserDto(questionFromUserRepository.save(questionFromUser));
    }

    public List<QuestionFromUserDto> getAllUnsolvedQuestions(){
        List<QuestionFromUser> questionFromUserList = questionFromUserRepository.findAllBySolved(false);
        return QUESTION_FROM_USER_MAPPER.convertToQuestionFromUserDtoList(questionFromUserList);
    }

    public QuestionFromUserDto getQuestionFromUserById(int id){
        QuestionFromUser question = questionFromUserRepository.findById(id).orElseThrow(()->new NotFoundException("Question not found"));
        return QUESTION_FROM_USER_MAPPER.convertToQuestionFromUserDto(question);
    }

    public QuestionFromUserDto solveQuestionFromUser(UpdateQuestionFromUserRequest updateQuestionFromUserRequest)  {
        QuestionFromUser question = questionFromUserRepository.findById(updateQuestionFromUserRequest.getId())
                .orElseThrow(()->new NotFoundException("Question not found"));
        question.setSolved(true);
        question.setSolvedBy(updateQuestionFromUserRequest.getSolvedBy());
        return QUESTION_FROM_USER_MAPPER.convertToQuestionFromUserDto(questionFromUserRepository.save(question));
    }

}
