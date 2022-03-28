package com.dag.hocam.repository;


import com.dag.hocam.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByIdEquals(int id);
    Optional<User> findByUsernameEquals(String username);

}
