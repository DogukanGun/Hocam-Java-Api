package com.dag.hocam.model.request.exampleQuestion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateExampleQuestionRequest {

    private String question;

    private String correctAnswer;

    private String solution;

    private Integer subjectId;

    private String level;

}
