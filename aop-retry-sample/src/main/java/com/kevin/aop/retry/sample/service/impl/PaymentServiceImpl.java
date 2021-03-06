package com.kevin.aop.retry.sample.service.impl;

import com.kevin.aop.retry.sample.annotion.Retryable;
import com.kevin.aop.retry.sample.service.PaymentService;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Retryable(maxRetryCount = 5, delayMillis = 5, expectCondition = RuntimeException.class)
  @Override
  public void pay() {
    Logger.getGlobal().info("【invoke pay method】:" + System.currentTimeMillis());
    throw new RuntimeException("RuntimeException...");

  }
}
