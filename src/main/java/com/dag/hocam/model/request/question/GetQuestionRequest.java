package com.dag.hocam.model.request.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetQuestionRequest {

    private String quizName;

    private boolean isQuestionFiltered = false;

    private int maxQuestionNumber = 15;
}
