package com.alkemy.ong.infrastructure.config.spring.security.common;

import com.alkemy.ong.infrastructure.rest.response.LoginErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@NoArgsConstructor
public class ResponseUtils {

  public static void setCustomForbiddenResponse(HttpServletResponse response) throws IOException {
    response.setStatus(HttpStatus.FORBIDDEN.value());
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    ObjectMapper mapper = new ObjectMapper();
    response.getWriter().write(mapper.writeValueAsString(getGenericErrorResponse()));
  }

  private static LoginErrorResponse getGenericErrorResponse() {
    return LoginErrorResponse.builder()
        .statusCode(HttpStatus.FORBIDDEN.value())
        .message("Access denied. Please, try to login again or contact your admin.")
        .build();
  }

}