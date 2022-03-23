package com.kevin.aop.retry.sample.aspect;

import com.kevin.aop.retry.sample.annotion.Retryable;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 重试切面
 *
 * @author kevin
 */
@Aspect
@Component
public class RetryAspect {


  @Pointcut("execution(public * com.kevin.aop.retry.sample.*.*(..)) && " +
      "@annotation(com.kevin.aop.retry.sample.annotion.Retryable)")
  public void pointcut() {

  }


  @Around("pointcut()")
  public Object around(ProceedingJoinPoint point) throws Throwable {
    Method currentMethod = getCurrentMethod(point);
    Retryable retryable = currentMethod.getAnnotation(Retryable.class);
    //最大次数
    int maxRetryCount = retryable.maxRetryCount();
    //无需处理
    if (maxRetryCount <= 1) {
      return point.proceed();
    }
    long millis = retryable.delayMillis();
    int times = 0;
    final Class<? extends Throwable> exceptionClass = retryable.expectCondition();
    while (times < maxRetryCount) {
      try {
        return point.proceed();
      } catch (Throwable e) {
        times++;
        if (millis > 0) {
          Thread.sleep(millis * 1000);
        }
        if (times >= maxRetryCount || !e.getClass().isAssignableFrom(exceptionClass)) {
          throw new Throwable(e);
        }

      }
    }
    return null;
  }


  private Method getCurrentMethod(ProceedingJoinPoint point) {
    try {
      Signature signature = point.getSignature();
      MethodSignature methodSignature = (MethodSignature) signature;
      Object target = point.getTarget();
      return target.getClass()
          .getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }


}
