package com.github.luiguip.chamber_of_deputies_service.config;

import com.github.luiguip.chamber_of_deputies_service.domain.port.application.DeputyApplicationPort;
import com.github.luiguip.chamber_of_deputies_service.domain.port.infrastructure.DeputyInfrastructurePort;
import com.github.luiguip.chamber_of_deputies_service.domain.service.DeputyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

  @Bean
  public DeputyApplicationPort deputyApplicationPort(DeputyInfrastructurePort deputyInfrastructurePort) {
    return new DeputyService(deputyInfrastructurePort);
  }
}
