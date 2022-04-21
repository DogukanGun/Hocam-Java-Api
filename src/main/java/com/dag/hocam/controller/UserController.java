package com.dag.hocam.controller;


import com.dag.hocam.model.request.user.UpdatePasswordRequest;
import com.dag.hocam.model.request.user.UpdateUserRequest;
import com.dag.hocam.sec.dto.RestResponse;
import com.dag.hocam.sec.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/getProfile")
    public ResponseEntity getProfile(@RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(RestResponse.of(authenticationService.getProfile(updateUserRequest)));
    }

    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(RestResponse.of(authenticationService.updateUser(updateUserRequest)));
    }

    @PostMapping("/updatepassword")
    public ResponseEntity updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest){
        return ResponseEntity.ok(RestResponse.of(authenticationService.updatePassword(updatePasswordRequest)));
    }
}
