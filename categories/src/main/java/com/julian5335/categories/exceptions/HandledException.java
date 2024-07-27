package com.julian5335.categories.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.ServletException;

public class HandledException extends ServletException {

  protected String key = "message";

  protected HttpStatus statusCode;
  
  HandledException(String key, String message, HttpStatus statusCode) {
    super(message);
    this.statusCode = statusCode;
    if (key != null) {
      this.key = key;
    }
  }

  public ResponseEntity<Object> toResponseEntity() {
    return ResponseEntity
      .status(this.statusCode)
      .body(new ErrorResponse(Map.of(this.key, this.getMessage())));
  }

}
