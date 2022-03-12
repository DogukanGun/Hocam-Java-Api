package com.dag.hocam.model.dto;


import com.dag.hocam.model.entity.Question;
import com.dag.hocam.model.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizDto {

    private Integer id;

    private Topic topic;

    private String quizName;

    private List<Question> questions;


}
