package com.dag.hocam.model.request.questionfromuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateQuestionFromUserRequest {

    private Integer id;

    private String solvedBy;
}
