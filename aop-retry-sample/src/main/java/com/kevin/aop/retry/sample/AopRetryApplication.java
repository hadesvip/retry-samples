package com.kevin.aop.retry.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 程序入口
 *
 * @author kevin
 */
@SpringBootApplication
@RestController
public class AopRetryApplication {

  public static void main(String[] args) {

    SpringApplication.run(AopRetryApplication.class, args);

  }


  @GetMapping("/")
  public String index() {
    return "AopRetryApplication start success...";
  }

}
