package com.kevin.aop.retry.sample.service.mock;

import com.kevin.aop.retry.sample.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class PaymentMockTest extends BaseMockTest {


  @InjectMocks
  private PaymentServiceImpl paymentService;


  @Test
  public void paymentTest() {

  }


}
