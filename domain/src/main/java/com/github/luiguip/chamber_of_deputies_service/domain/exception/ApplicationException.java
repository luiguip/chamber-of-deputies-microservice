package com.github.luiguip.chamber_of_deputies_service.domain.exception;

public class ApplicationException extends Exception{

  public ApplicationException(String message) {
    super(message);
  }

  public ApplicationException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApplicationException(Throwable cause) {
    super(cause);
  }
}
