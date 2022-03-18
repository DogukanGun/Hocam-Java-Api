package com.dag.hocam.controller;

import com.dag.hocam.model.dto.QuestionFromUserDto;
import com.dag.hocam.model.request.questionfromuser.CreateQuestionFromUserRequest;
import com.dag.hocam.model.request.questionfromuser.UpdateQuestionFromUserRequest;
import com.dag.hocam.service.QuestionFromUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questionfromuser")
@RequiredArgsConstructor
public class QuestionFromUserController {

    private final QuestionFromUserService questionFromUserService;

    @PostMapping("get/all")
    public List<QuestionFromUserDto> getAllQuestionFromUser(){
        return questionFromUserService.getAllUnsolvedQuestions();
    }

    @PostMapping("get/id/{questionId}")
    public QuestionFromUserDto getQuestionFromUser(@PathVariable int questionId){
        return questionFromUserService.getQuestionFromUserById(questionId);
    }

    @PostMapping("solve/question")
    public QuestionFromUserDto solveQuestionFromUser(@RequestBody UpdateQuestionFromUserRequest updateQuestionFromUserRequest){
        return questionFromUserService.solveQuestionFromUser(updateQuestionFromUserRequest);
    }
}
