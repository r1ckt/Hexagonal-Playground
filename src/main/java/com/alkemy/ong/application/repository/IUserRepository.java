package com.alkemy.ong.application.repository;

import com.alkemy.ong.domain.User;

public interface IUserRepository {
  User add(User user);
  User findByEmail(String email);
}
