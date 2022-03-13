package com.dag.hocam.repository;

import com.dag.hocam.model.dto.TopicDto;
import com.dag.hocam.model.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Integer> {

    List<Topic> findAllByTopicName(String topicName);
}
