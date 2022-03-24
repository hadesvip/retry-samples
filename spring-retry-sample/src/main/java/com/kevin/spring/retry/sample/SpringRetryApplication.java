package com.kevin.spring.retry.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * 程序入口
 *
 * @author kevin
 */
@SpringBootApplication
@EnableRetry
public class SpringRetryApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringRetryApplication.class, args);
  }


}
