package com.alkemy.ong.infrastructure.rest.mapper;

import com.alkemy.ong.domain.User;
import com.alkemy.ong.infrastructure.rest.request.AuthenticationRequest;
import com.alkemy.ong.infrastructure.rest.response.UserRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapper {

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User toDomain(AuthenticationRequest authRequest) {
    if (authRequest == null) {
      return null;
    }
    return User.builder()
        .firstName(authRequest.getFirstName())
        .lastName(authRequest.getLastName())
        .email(authRequest.getEmail())
        .password(passwordEncoder.encode(authRequest.getPassword()))
        .build();
  }

  public UserRegisterResponse toResponse(User user) {
    if (user == null) {
      return null;
    }
    return UserRegisterResponse.builder()
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .build();
  }
}

