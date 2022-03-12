package com.dag.hocam.repository;

import com.dag.hocam.model.entity.ExampleQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleQuestionRepository extends JpaRepository<ExampleQuestion,Integer> {
}
