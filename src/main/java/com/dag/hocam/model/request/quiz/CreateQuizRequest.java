package com.dag.hocam.model.request.quiz;


import com.dag.hocam.model.request.question.CreateQuestionRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateQuizRequest {

    private String quizName;

    private Integer topicId;

    private List<CreateQuestionRequest> createQuestionRequests;
}
