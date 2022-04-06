package com.dag.hocam.sec.service;


import com.dag.hocam.model.dto.UserDto;
import com.dag.hocam.model.entity.User;
import com.dag.hocam.model.request.user.CreateUserRequest;
import com.dag.hocam.model.request.user.UpdateUserRequest;
import com.dag.hocam.sec.dto.LoginResponse;
import com.dag.hocam.sec.dto.SecLoginRequestDto;
import com.dag.hocam.sec.enums.EnumJwtConstant;
import com.dag.hocam.sec.enums.UserType;
import com.dag.hocam.sec.security.JwtTokenGenerator;
import com.dag.hocam.sec.security.JwtUserDetails;
import com.dag.hocam.service.UserEntityService;
import com.dag.hocam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserEntityService cusCustomerEntityService;
    private final UserService cusCustomerService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    public UserDto register(CreateUserRequest cusCustomerSaveRequestDto) {
        UserDto cusCustomerDto = cusCustomerService.createUser(cusCustomerSaveRequestDto, UserType.USER);
        return cusCustomerDto;
    }

    public UserDto registerAsTeacher(CreateUserRequest cusCustomerSaveRequestDto) {
        UserDto cusCustomerDto = cusCustomerService.createUser(cusCustomerSaveRequestDto, UserType.ADMIN);
        return cusCustomerDto;
    }

    public UserDto getProfile(UpdateUserRequest updateUserRequest){
        return cusCustomerService.getUserProfile(updateUserRequest);
    }

    public UserDto updateUser(UpdateUserRequest updateUserRequest){
        return cusCustomerService.updateUser(updateUserRequest);
    }
    public LoginResponse login(SecLoginRequestDto secLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(secLoginRequestDto.getUsername(), secLoginRequestDto.getPassword());
        if (!authenticationToken.isAuthenticated()){
            return null;
        }
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String bearer = EnumJwtConstant.BEARER.getConstant() + token;
        User user = getCurrentCustomer();

        LoginResponse loginResponse = LoginResponse.builder()
                .username(secLoginRequestDto.getUsername())
                .token(bearer)
                .userType(user.getUserType())
                .build();

        return loginResponse;
    }

    public User getCurrentCustomer() {

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        User cusCustomer = null;
        if (jwtUserDetails != null){
            cusCustomer = cusCustomerEntityService.getUserById(jwtUserDetails.getId());
        }

        return cusCustomer;
    }

    public Integer getCurrentCustomerId(){

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        return jwtUserDetails.getId();
    }

    private JwtUserDetails getCurrentJwtUserDetails() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JwtUserDetails jwtUserDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof JwtUserDetails){
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        }
        return jwtUserDetails;
    }
}
