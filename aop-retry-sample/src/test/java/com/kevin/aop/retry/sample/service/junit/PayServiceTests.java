package com.kevin.aop.retry.sample.service.junit;

import com.kevin.aop.retry.sample.service.PaymentService;
import com.kevin.aop.retry.sample.service.junit.BaseJunitTest;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;

public class PayServiceTests extends BaseJunitTest {


  @Resource
  private PaymentService paymentService;


  @Test
  public void payTest() {

    paymentService.pay();


  }


}
