package com.kevin.aop.retry.sample.service.mock;

import com.kevin.aop.retry.sample.exception.RetryException;
import com.kevin.aop.retry.sample.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PaymentMockTest extends BaseMockTest {

  @Test
  public void paymentTest() {
    PaymentServiceImpl paymentServiceMock = Mockito.mock(PaymentServiceImpl.class);
    Mockito.doThrow(new RetryException()).when(paymentServiceMock).pay();
    Assertions.assertThrows(RetryException.class, paymentServiceMock::pay);

  }


}
