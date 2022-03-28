package com.dag.hocam.model.request.completedQuiz;

import com.dag.hocam.model.dto.QuestionDto;
import com.dag.hocam.model.dto.QuizDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCompletedQuizRequest {
    private String username;

    private Integer quizId;

    private Double point;

    private List<Integer> questionDtoList;
}
