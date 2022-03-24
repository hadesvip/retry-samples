package com.kevin.spring.retry.sample.exception;

public class RetryException extends RuntimeException {

  public RetryException(String message) {
    super(message);
  }

  public RetryException() {

  }
}