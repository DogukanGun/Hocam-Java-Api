package com.dag.hocam.repository;

import com.dag.hocam.model.entity.CompletedQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedQuizRepository extends JpaRepository<CompletedQuiz,Integer> {
}
