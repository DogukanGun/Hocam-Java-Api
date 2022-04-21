package com.dag.hocam.controller;


import com.dag.hocam.model.dto.UserDto;
import com.dag.hocam.model.request.user.CreateUserRequest;
import com.dag.hocam.sec.dto.RestResponse;
import com.dag.hocam.sec.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register/teacher")
    public ResponseEntity registerAsTeacher(@RequestBody CreateUserRequest createUserRequest){

        UserDto cusCustomerDto =authenticationService.registerAsTeacher(createUserRequest);

        return ResponseEntity.ok(RestResponse.of(cusCustomerDto));
    }
}
