package com.kevin.aop.retry.sample.exception;

/**
 * 重试异常
 *
 * @author wangyong
 */
public class RetryException extends RuntimeException {

  public RetryException(String message) {
    super(message);
  }
}
