package com.kevin.spring.retry.sample.service.junit;

import com.kevin.spring.retry.sample.service.PaymentService;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;

public class PaymentServiceJunitTest extends BaseJunitTest {


  @Resource
  private PaymentService paymentService;



  @Test
  public void payTest() {
    paymentService.pay();
  }




}
