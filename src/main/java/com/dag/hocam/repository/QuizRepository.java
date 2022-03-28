package com.dag.hocam.repository;

import com.dag.hocam.model.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {

    Optional<Quiz> findByQuizName(String quizName);
    Optional<Quiz> findAllById(int quizId);
    Optional<List<Quiz>> findAllByTopicId(int topicId);
}
