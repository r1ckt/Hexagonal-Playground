package com.alkemy.ong.infrastructure.rest.resource;

import com.alkemy.ong.application.service.usecase.ICreateUserUseCase;
import com.alkemy.ong.domain.User;
import com.alkemy.ong.infrastructure.rest.mapper.UserRegisterMapper;
import com.alkemy.ong.infrastructure.rest.request.AuthenticationRequest;
import com.alkemy.ong.infrastructure.rest.response.UserRegisterResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserResource {

  private final ICreateUserUseCase createUserUseCase;

  private final UserRegisterMapper userRegisterMapper;

  @PostMapping(value = "auth/register",
      produces = {"application/json"},
      consumes = {"application/json"})
  public ResponseEntity<UserRegisterResponse> create(@Valid @RequestBody AuthenticationRequest authRequest) {
    User user = userRegisterMapper.toDomain(authRequest);
    UserRegisterResponse response = userRegisterMapper.toResponse(createUserUseCase.add(user));
    return new ResponseEntity<UserRegisterResponse>(response, HttpStatus.CREATED);
  }

}
