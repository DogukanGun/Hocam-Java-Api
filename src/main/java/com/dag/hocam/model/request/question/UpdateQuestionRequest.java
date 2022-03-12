package com.dag.hocam.model.request.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateQuestionRequest {

    private Integer id;

    private String question;

    private String correctAnswer;

    private Integer quizId;
}
