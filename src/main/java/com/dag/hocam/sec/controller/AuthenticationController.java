package com.dag.hocam.sec.controller;

import com.dag.hocam.model.dto.UserDto;
import com.dag.hocam.model.request.user.CreateUserRequest;
import com.dag.hocam.model.request.user.UpdateUserRequest;
import com.dag.hocam.sec.dto.LoginResponse;
import com.dag.hocam.sec.dto.RestResponse;
import com.dag.hocam.sec.dto.SecLoginRequestDto;
import com.dag.hocam.sec.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecLoginRequestDto secLoginRequestDto){

        LoginResponse loginResponse = authenticationService.login(secLoginRequestDto);
        if (loginResponse == null){
            return ResponseEntity.ok(RestResponse.error(loginResponse));
        }
        return ResponseEntity.ok(RestResponse.of(loginResponse));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody CreateUserRequest createUserRequest){

        UserDto cusCustomerDto =authenticationService.register(createUserRequest);

        return ResponseEntity.ok(RestResponse.of(cusCustomerDto));
    }
}
