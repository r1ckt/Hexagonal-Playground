package com.alkemy.ong.infrastructure.rest.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRegisterRequest {

  private String firstName;

  private String lastName;

  @Email(message = "Enter a valid email")
  private String email;

  @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters long")
  private String password;


}
