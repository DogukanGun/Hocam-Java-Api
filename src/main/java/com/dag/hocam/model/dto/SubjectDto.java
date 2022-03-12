package com.dag.hocam.model.dto;

import com.dag.hocam.model.entity.ExampleQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectDto {

    private String subjectName;

    private String subjectVideoUrl;

    private List<ExampleQuestion> exampleQuestions;
}
