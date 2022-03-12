package com.dag.hocam.model.request.subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateSubjectRequest {

    private Integer id;

    private String subjectName;

    private String subjectVideoUrl;
}
