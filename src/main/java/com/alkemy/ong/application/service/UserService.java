package com.alkemy.ong.application.service;

import com.alkemy.ong.application.exception.UserAlreadyExistsException;
import com.alkemy.ong.application.repository.IUserRepository;
import com.alkemy.ong.application.service.usecase.ICreateUserUseCase;
import com.alkemy.ong.domain.User;
import com.alkemy.ong.infrastructure.config.spring.security.common.Role;
import com.alkemy.ong.infrastructure.database.mapper.UserEntityMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService implements ICreateUserUseCase {
  private final IUserRepository userRepository;
  @Override
  public User add(User user) {
    if (userRepository.findByEmail(user.getEmail()) != null) {
      throw new UserAlreadyExistsException(
          "This email address: " + user.getEmail() + " is already being used");
    }
    user.setRole(Role.USER.getFullRoleName());
    return userRepository.add(user);
  }
}

