package com.alkemy.ong.infrastructure.database.repository;

import com.alkemy.ong.application.repository.IUserRepository;
import com.alkemy.ong.domain.User;
import com.alkemy.ong.infrastructure.database.entity.RoleEntity;
import com.alkemy.ong.infrastructure.database.entity.UserEntity;
import com.alkemy.ong.infrastructure.database.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class UserRepository implements IUserRepository {

  private final IUserSpringRepository userSpringRepository;
  private final UserEntityMapper userEntityMapper;
  private final IRoleSpringRepository roleSpringRepository;


  @Override
  @Transactional
  public User add(User user) {
    UserEntity userEntity = userEntityMapper.toEntity(user);
    userEntity.setRole(getRoleEntity(user.getRole()));
    return userEntityMapper.toDomain(userSpringRepository.save(userEntity));
  }

  private RoleEntity getRoleEntity(String role) {
    return roleSpringRepository.findByName(role);
  }

  @Override
  public User findByEmail(String email) {
    return userEntityMapper.toDomain(userSpringRepository.findByEmail(email));
  }
}
