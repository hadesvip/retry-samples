package com.kevin.spring.retry.sample.service.impl;

import com.alibaba.fastjson.JSON;
import com.kevin.spring.retry.sample.exception.RetryException;
import com.kevin.spring.retry.sample.service.PaymentService;
import java.util.logging.Logger;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {


  /**
   * 【参数解释】
   * value:异常触发条件
   * maxAttempts:最大重试次数；
   * backoff：重试策略；
   * delay：重试延迟时间；
   * multiplier：delay 间隔时间倍数
   */
  @Retryable(value = RetryException.class, maxAttempts = 3,
      backoff = @Backoff(delay = 2000, multiplier = 1.5))
  @Override
  public void pay() {
    Logger.getGlobal().info("【invoke pay method】:" + System.currentTimeMillis());
    throw new RetryException("RetryException...");

  }

  /**
   * 熔断方法，重试次数结束后如果还有异常调用此方法，方法的入参为Exception
   */
  @Recover
  public void failCallbackPay(Exception exception) {
    Logger.getGlobal().info("重试失败,异常:" + JSON.toJSONString(exception));
    exception.printStackTrace();
  }
}
