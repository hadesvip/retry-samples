package com.kevin.aop.retry.sample.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 重试注解
 *
 * @author kevin
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Retryable {

  /**
   * 重试触发条件
   */
  Class<? extends Throwable> expectCondition() default RuntimeException.class;

  /**
   * 最大重试次数，默认3
   */
  int maxRetryCount() default 3;

  /**
   * 重试间隔,默认1s
   */
  long delayMillis() default 1;


}
