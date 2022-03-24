package com.kevin.aop.retry.sample.service.mock;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseMockTest {

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

}
