package com.dag.hocam.service;


import com.dag.hocam.model.dto.UserDto;
import com.dag.hocam.model.entity.User;
import com.dag.hocam.model.request.user.CreateUserRequest;
import com.dag.hocam.model.request.user.UpdateUserRequest;
import com.dag.hocam.repository.UserRepository;
import com.dag.hocam.sec.enums.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.hocam.model.mapper.UserMapper.USER_MAPPER;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserDto createUser(CreateUserRequest createUserRequest, UserType userType){
        User user = USER_MAPPER.createUser(createUserRequest);
        user.setUserType(userType.getLabel());
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        return USER_MAPPER.convertToUserDto(userRepository.save(user));
    }

    public UserDto getUserProfile(UpdateUserRequest updateUserRequest){
        return USER_MAPPER.convertToUserDto(userRepository.findByUsernameEquals(updateUserRequest.getUsername())
                .orElseThrow(()->new NotFoundException("User Not Found")));
    }

    public UserDto updateUser(UpdateUserRequest updateUserRequest){
        if (!updateUserRequest.getUsername().equals("")){
            User user = userRepository.findByUsernameEquals(updateUserRequest.getUsername())
                    .orElseThrow(()->new NotFoundException("User Not Found"));
            if (!updateUserRequest.getPhoneNumber().equals("")){
                user.setPhoneNumber(updateUserRequest.getPhoneNumber());
            }
            if (!updateUserRequest.getEmail().equals("")){
                user.setEmail(updateUserRequest.getEmail());
            }
            return USER_MAPPER.convertToUserDto(userRepository.save(user));
        }
        throw new NotFoundException("User not found");
    }



}
