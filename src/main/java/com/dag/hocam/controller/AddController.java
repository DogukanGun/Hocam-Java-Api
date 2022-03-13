package com.dag.hocam.controller;

import com.dag.hocam.model.dto.QuestionDto;
import com.dag.hocam.model.dto.QuizDto;
import com.dag.hocam.model.dto.SubjectDto;
import com.dag.hocam.model.dto.TopicDto;
import com.dag.hocam.model.request.question.CreateQuestionRequest;
import com.dag.hocam.model.request.question.UpdateQuestionRequest;
import com.dag.hocam.model.request.quiz.CreateQuizRequest;
import com.dag.hocam.model.request.subject.CreateSubjectRequest;
import com.dag.hocam.model.request.topic.CreateTopicRequest;
import com.dag.hocam.service.CompletedQuizService;
import com.dag.hocam.service.QuizService;
import com.dag.hocam.service.SubjectService;
import com.dag.hocam.service.TopicService;
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

    @PostMapping("quiz")
    public QuizDto createQuiz(@RequestBody CreateQuizRequest createQuizRequest) {
        return quizService.createQuiz(createQuizRequest);
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
