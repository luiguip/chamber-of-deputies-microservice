package com.github.luiguip.chamber_of_deputies_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class RunnerApplication {

  public static void main(String[] args) {
    SpringApplication.run(RunnerApplication.class, args);
  }


}
