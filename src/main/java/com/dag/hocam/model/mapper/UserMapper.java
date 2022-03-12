package com.dag.hocam.model.mapper;


import com.dag.hocam.model.dto.UserDto;
import com.dag.hocam.model.entity.User;
import com.dag.hocam.model.request.user.CreateUserRequest;
import com.dag.hocam.model.request.user.UpdateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDto convertToUserDto(User user);

    User createUser(CreateUserRequest createUserRequest);

    void updateUser(@MappingTarget User user, UpdateUserRequest updateUserRequest);
}
