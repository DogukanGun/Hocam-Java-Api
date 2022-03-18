package com.dag.hocam.repository;

import com.dag.hocam.model.entity.QuestionFromUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionFromUserRepository extends JpaRepository<QuestionFromUser,Integer> {

    List<QuestionFromUser> findAllBySolved(boolean solved);
}
