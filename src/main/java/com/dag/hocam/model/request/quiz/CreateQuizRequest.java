package com.dag.hocam.model.request.quiz;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateQuizRequest {

    private String quizName;

    private Integer topicId;
}
