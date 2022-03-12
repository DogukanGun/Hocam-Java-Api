package com.dag.hocam.model.dto;


import com.dag.hocam.model.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicDto {

    private Integer id;

    private String topicName;

    private List<Quiz> quizzes;
}
