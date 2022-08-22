package com.alkemy.ong.infrastructure.rest.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AuthenticationRequest {

  @NotNull(message = "Name cannot be null")
  private String firstName;

  @NotNull(message = "Last name cannot be null")
  private String lastName;

  @Email(message = "Email should be valid")
  private String email;

  @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters long")
  private String password;


}
