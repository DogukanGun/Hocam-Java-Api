package com.dag.hocam.model.request.question;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateQuestionRequest {

    private String question;

    private String correctAnswer;

    private Integer quizId;

}
