package com.github.luiguip.chamber_of_deputies_service.domain.exception;

public class InfrastructureException extends Exception{

  public InfrastructureException(Throwable cause) {
    super(cause);
  }

  public InfrastructureException(String message) {
    super(message);
  }

  public InfrastructureException(String message, Throwable cause) {
    super(message, cause);
  }
}
