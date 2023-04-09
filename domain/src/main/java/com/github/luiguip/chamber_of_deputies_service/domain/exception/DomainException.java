package com.github.luiguip.chamber_of_deputies_service.domain.exception;

public class DomainException extends Exception{

  public DomainException(String message) {
    super(message);
  }

  public DomainException(String message, Throwable cause) {
    super(message, cause);
  }

  public DomainException(Throwable cause) {
    super(cause);
  }
}
