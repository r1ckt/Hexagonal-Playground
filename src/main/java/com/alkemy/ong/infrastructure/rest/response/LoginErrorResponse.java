package com.alkemy.ong.infrastructure.rest.response;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class LoginErrorResponse {

  private int statusCode;
  private String message;
  private List<@NotEmpty String> moreInfo;

}
