package com.alkemy.ong.infrastructure.rest.resource;

import com.alkemy.ong.application.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResourse {

  @Autowired
  private IUserRepository userRepository;

}
