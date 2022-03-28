package com.dag.hocam.model.request.quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetAllQuizzesRequest {

    private boolean isQuizFilter = false;

    private Integer topicId;
}
