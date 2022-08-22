package com.alkemy.ong.application.service;

import com.alkemy.ong.application.service.usecase.ICreateUserUseCase;
import com.alkemy.ong.infrastructure.database.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeanConfig {

/* login stuff
@Bean
  public ILoginUseCase authenticationService(AuthenticationManager authenticationManager,
      UserRepository userRepository) {
    return new AuthenticationService(authenticationManager, userRepository);
  }
 */

  @Bean
  public ICreateUserUseCase createUserService(UserRepository userRepository) {
    return new UserService(userRepository);
  }

}
