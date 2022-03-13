package com.dag.hocam.model.request.completedQuiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCompletedQuizRequest {
    private Integer userId;

    private Integer quizId;

    private Double point;
}
