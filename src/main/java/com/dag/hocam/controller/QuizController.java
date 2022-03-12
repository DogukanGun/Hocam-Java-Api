package com.dag.hocam.controller;

import com.dag.hocam.model.dto.CompletedQuizDto;
import com.dag.hocam.model.dto.QuestionDto;
import com.dag.hocam.model.dto.QuizDto;
import com.dag.hocam.model.request.completedQuiz.CreateCompletedQuizRequest;
import com.dag.hocam.model.request.question.CreateQuestionRequest;
import com.dag.hocam.model.request.question.UpdateQuestionRequest;
import com.dag.hocam.model.request.quiz.CreateQuizRequest;
import com.dag.hocam.service.CompletedQuizService;
import com.dag.hocam.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private final CompletedQuizService completedQuizService;

    @PostMapping("addQuiz")
    public QuizDto createQuiz(@RequestBody CreateQuizRequest createQuizRequest) {
        return quizService.createQuiz(createQuizRequest);
    }

    @PostMapping("question/getAll/{quizName}")
    public List<QuestionDto> getQuestionsByQuizName(@PathVariable String quizName) {
        return quizService.getQuestionsByQuizName(quizName);
    }

    @PostMapping("question/addQuestion")
    public QuestionDto createQuestion(@RequestBody CreateQuestionRequest createQuestionRequest) {
        return quizService.createQuestion(createQuestionRequest);
    }

    @PostMapping("getAll")
    public List<QuizDto> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping("question/updateQuestion")
    public QuestionDto updateQuestion(@RequestBody UpdateQuestionRequest updateQuestionRequest) {
        return quizService.updateQuestion(updateQuestionRequest);
    }

    @PostMapping("question/complete/quiz")
    public CompletedQuizDto completedQuiz(@RequestBody CreateCompletedQuizRequest createCompletedQuizRequest){
        return completedQuizService.completedQuiz(createCompletedQuizRequest);
    }

}