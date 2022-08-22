package com.alkemy.ong.infrastructure.database.mapper;

import com.alkemy.ong.domain.User;
import com.alkemy.ong.infrastructure.config.spring.security.common.JwtUtils;
import com.alkemy.ong.infrastructure.database.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class UserEntityMapper {

  @Autowired
  private JwtUtils jwtUtils;
  public User toDomain(UserEntity userEntity) {
    if (userEntity == null) {
      return null;
    }
    return User.builder()
        .email(userEntity.getEmail())
        .firstName(userEntity.getFirstName())
        .lastName(userEntity.getLastName())
        .imageUrl(userEntity.getImageUrl())
        .password(userEntity.getPassword())
        .token(JwtUtils.create(userEntity))
        .build();
  }

  public UserEntity toEntity(User user) {
    if (user == null) {
      return null;
    }
    return UserEntity.builder()
        .email(user.getEmail())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .imageUrl(user.getImageUrl())
        .password(user.getPassword())
        .build();
  }

}
