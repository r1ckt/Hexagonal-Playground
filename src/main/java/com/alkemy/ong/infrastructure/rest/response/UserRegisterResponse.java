package com.alkemy.ong.infrastructure.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserRegisterResponse {

  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private String imageUrl;

}
