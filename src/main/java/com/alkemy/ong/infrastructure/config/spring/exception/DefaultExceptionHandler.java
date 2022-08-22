package com.alkemy.ong.infrastructure.config.spring.exception;

import com.alkemy.ong.application.exception.UserAlreadyExistsException;
import com.alkemy.ong.infrastructure.rest.response.LoginErrorResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {
  private static final String INVALID_INPUT_DATA = "Invalid input data.";
  @ExceptionHandler(value = UserAlreadyExistsException.class)
  protected ResponseEntity<LoginErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException e) {
    LoginErrorResponse  errorResponse =
        buildError(
            HttpStatus.BAD_REQUEST, INVALID_INPUT_DATA, e.getMessage()
        );
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

  private LoginErrorResponse buildError(HttpStatus httpStatus, String message, List<String> moreInfo) {
    return LoginErrorResponse.builder()
        .statusCode(httpStatus.value())
        .message(message)
        .moreInfo(moreInfo)
        .build();
  }
  private LoginErrorResponse buildError(HttpStatus httpStatus, String message, String moreInfo) {
    return buildError(httpStatus, message, List.of(moreInfo));
  }
  
}
