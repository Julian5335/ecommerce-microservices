package com.julian5335.categories.exceptions;

import org.springframework.http.HttpStatus;

public class DeleteNotAllowedException extends HandledException {
  
  public DeleteNotAllowedException(String key, String message, HttpStatus status) {
    super(message, message, status);
  }

}
