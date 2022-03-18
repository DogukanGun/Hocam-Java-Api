package com.dag.hocam.controller;

import com.dag.hocam.model.dto.CompletedQuizDto;
import com.dag.hocam.model.dto.QuestionDto;
import com.dag.hocam.model.dto.QuizDto;
import com.dag.hocam.model.entity.Quiz;
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

    @PostMapping("question/getAll/{quizName}")
    public List<QuestionDto> getQuestionsByQuizName(@PathVariable String quizName) {
        return quizService.getQuestionsByQuizName(quizName);
    }

    @PostMapping("getAll")
    public List<QuizDto> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping("question/complete/quiz")
    public CompletedQuizDto completedQuiz(@RequestBody CreateCompletedQuizRequest createCompletedQuizRequest){
        return completedQuizService.completedQuiz(createCompletedQuizRequest);
    }

    @PostMapping("quiz/solved/{username}")
    public List<CompletedQuizDto> getCompletedQuizzes(@PathVariable String username){
        return completedQuizService.getCompletedQuizzes(username);
    }

}