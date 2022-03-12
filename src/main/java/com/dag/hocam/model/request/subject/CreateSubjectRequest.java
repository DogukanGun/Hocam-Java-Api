package com.dag.hocam.model.request.subject;


import com.dag.hocam.model.request.exampleQuestion.CreateExampleQuestionRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSubjectRequest {

    private String subjectName;

    private String subjectVideoUrl;

    private List<CreateExampleQuestionRequest> exampleQuestionRequests;
}
