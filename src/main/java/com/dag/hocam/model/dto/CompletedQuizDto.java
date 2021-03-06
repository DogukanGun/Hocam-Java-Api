package com.dag.hocam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompletedQuizDto {

    private Integer userId;

    private Integer quizId;

    private String quizName;

    private Double point;
}
