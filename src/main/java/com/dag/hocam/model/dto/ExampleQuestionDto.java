package com.dag.hocam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExampleQuestionDto {

    private String question;

    private String correctAnswer;

    private String solution;

    private Integer subjectId;

}
