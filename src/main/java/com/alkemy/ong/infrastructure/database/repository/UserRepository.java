package com.alkemy.ong.infrastructure.database.repository;

import com.alkemy.ong.application.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserRepository implements IUserRepository {

  private final IUserSpringRepository userSpringRepository;

}
