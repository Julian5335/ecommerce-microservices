package com.julian5335.categories.exceptions;

public class NotFoundByIdException extends NotFoundException {
  
  public NotFoundByIdException() {
    super("id");
  }

}
