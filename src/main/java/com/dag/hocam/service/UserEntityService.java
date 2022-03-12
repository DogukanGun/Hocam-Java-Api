package com.dag.hocam.service;

import com.dag.hocam.model.entity.User;
import com.dag.hocam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class UserEntityService {
    private final UserRepository userRepository;

    public User getUserById(int id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException("User Not Found"));
    }
    public User getUserByUsername(String username){
        return userRepository.findByUsernameEquals(username).orElseThrow(()->new NotFoundException("User Not Found"));
    }

}
