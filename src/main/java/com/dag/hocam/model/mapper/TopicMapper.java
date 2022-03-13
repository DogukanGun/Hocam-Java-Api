package com.dag.hocam.model.mapper;


import com.dag.hocam.model.dto.TopicDto;
import com.dag.hocam.model.entity.Topic;
import com.dag.hocam.model.request.topic.CreateTopicRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    TopicMapper TOPIC_MAPPER = Mappers.getMapper(TopicMapper.class);

    TopicDto convertToTopicDto(Topic topic);

    Topic createTopic(CreateTopicRequest createTopicRequest);

    List<TopicDto> convertToTopicDtoList(List<Topic> topics);
}
