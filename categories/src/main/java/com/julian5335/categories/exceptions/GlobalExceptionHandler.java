package com.julian5335.categories.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {
    Map<String, String> errors = new HashMap<>();
      for (FieldError error : e.getFieldErrors()) {
          errors.put(error.getField(), error.getDefaultMessage());
      }
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse(errors));
  }
  
  @ExceptionHandler(HandledException.class)
  protected ResponseEntity<Object> handleHandledException(HandledException e) {
    return e.toResponseEntity();
  }
  
  @ExceptionHandler(Exception.class)
  protected ResponseEntity<Object> handleException(Exception e) {
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(new ErrorResponse(Map.of("message", Errors.INTERNAL_SERVER_ERROR)));
  }

}
