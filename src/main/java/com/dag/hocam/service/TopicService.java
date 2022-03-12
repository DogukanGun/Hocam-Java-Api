package com.dag.hocam.service;


import com.dag.hocam.model.dto.TopicDto;
import com.dag.hocam.model.entity.Topic;
import com.dag.hocam.model.request.topic.CreateTopicRequest;
import com.dag.hocam.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.dag.hocam.model.mapper.TopicMapper.TOPIC_MAPPER;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicDto addTopic(CreateTopicRequest createTopicRequest){
        Topic topic = TOPIC_MAPPER.createTopic(createTopicRequest);
        return TOPIC_MAPPER.convertToTopicDto(topicRepository.save(topic));
    }
}
