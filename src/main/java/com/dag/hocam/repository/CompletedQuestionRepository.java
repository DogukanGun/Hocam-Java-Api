package com.dag.hocam.repository;

import com.dag.hocam.model.entity.CompletedQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompletedQuestionRepository extends JpaRepository<CompletedQuestion,Integer> {
    List<CompletedQuestion> findAllByUserId(int userId);
}
