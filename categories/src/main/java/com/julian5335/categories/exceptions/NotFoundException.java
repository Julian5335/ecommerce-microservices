package com.julian5335.categories.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HandledException {
  
  public NotFoundException(String key) {
    super(key, Errors.NOT_FOUND, HttpStatus.NOT_FOUND);
  }

}
