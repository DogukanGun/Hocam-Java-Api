package com.dag.hocam.controller;


import com.dag.hocam.model.dto.TopicDto;
import com.dag.hocam.model.entity.Topic;
import com.dag.hocam.model.request.topic.CreateTopicRequest;
import com.dag.hocam.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("topic")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping("all")
    public List<TopicDto> getAllTopics(){
        return topicService.getAllTopics();
    }

    @PostMapping("all/{name}")
    public List<TopicDto> getAllTopicsByName(@PathVariable String name){
        return topicService.getAllTopics(name);
    }
}
