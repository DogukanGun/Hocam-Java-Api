package com.dag.hocam.controller;


import com.dag.hocam.model.dto.TopicDto;
import com.dag.hocam.model.entity.Topic;
import com.dag.hocam.model.request.topic.CreateTopicRequest;
import com.dag.hocam.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topic")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping("addTopic")
    public TopicDto createTopic(CreateTopicRequest createTopicRequest){
        return topicService.addTopic(createTopicRequest);
    }
}
