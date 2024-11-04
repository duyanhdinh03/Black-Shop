package com.ivandang.hmshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<String> handleDataNotFoundException(DataNotFoundException ex) {
    // Return 404 Not Found Error
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());
  }

  // Xử lý InvalidParamException
  @ExceptionHandler(InvalidParamException.class)
  public ResponseEntity<String> handleInvalidParamException(InvalidParamException ex) {
    // Return 400 BAD REQUEST Error
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGenericException(Exception ex) {
    // Return 500 INTERNAL SERVER Error
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An unexpected error occurred: " + ex.getMessage());
  }

}
