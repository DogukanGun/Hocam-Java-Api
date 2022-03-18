package com.dag.hocam.controller;

import com.dag.hocam.model.dto.*;
import com.dag.hocam.model.request.question.CreateQuestionRequest;
import com.dag.hocam.model.request.question.UpdateQuestionRequest;
import com.dag.hocam.model.request.questionfromuser.CreateQuestionFromUserRequest;
import com.dag.hocam.model.request.quiz.CreateQuizRequest;
import com.dag.hocam.model.request.subject.CreateSubjectRequest;
import com.dag.hocam.model.request.topic.CreateTopicRequest;
import com.dag.hocam.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("add")
@RequiredArgsConstructor
public class AddController {

    private final QuizService quizService;
    private final SubjectService subjectService;
    private final TopicService topicService;
    private final QuestionFromUserService questionFromUserService;

    @PostMapping("quiz")
    public QuizDto createQuiz(@RequestBody CreateQuizRequest createQuizRequest) {
        return quizService.createQuiz(createQuizRequest);
    }

    @PostMapping("questionfromuser")
    public QuestionFromUserDto addQuestionFromUser(@RequestBody CreateQuestionFromUserRequest createQuestionFromUserRequest){
        return questionFromUserService.createQuestionFromUser(createQuestionFromUserRequest);
    }

    @PostMapping("question")
    public QuestionDto createQuestion(@RequestBody CreateQuestionRequest createQuestionRequest) {
        return quizService.createQuestion(createQuestionRequest);
    }

    @PostMapping("question/update")
    public QuestionDto updateQuestion(@RequestBody UpdateQuestionRequest updateQuestionRequest) {
        return quizService.updateQuestion(updateQuestionRequest);
    }

    @PostMapping("subject")
    public SubjectDto createSubject(@RequestBody CreateSubjectRequest createSubjectRequest) {
        return subjectService.createSubject(createSubjectRequest);
    }

    @PostMapping("topic")
    public TopicDto createTopic(@RequestBody CreateTopicRequest createTopicRequest){
        return topicService.addTopic(createTopicRequest);
    }
}
