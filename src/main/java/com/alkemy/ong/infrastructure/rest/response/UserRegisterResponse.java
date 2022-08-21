package com.alkemy.ong.infrastructure.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRegisterResponse {

  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private String imageUrl;

}
