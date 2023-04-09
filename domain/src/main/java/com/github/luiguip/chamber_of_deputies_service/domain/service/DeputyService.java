package com.github.luiguip.chamber_of_deputies_service.domain.service;

import com.github.luiguip.chamber_of_deputies_service.domain.exception.DomainException;
import com.github.luiguip.chamber_of_deputies_service.domain.exception.InfrastructureException;
import com.github.luiguip.chamber_of_deputies_service.domain.model.Deputy;
import com.github.luiguip.chamber_of_deputies_service.domain.port.application.DeputyApplicationPort;
import com.github.luiguip.chamber_of_deputies_service.domain.port.infrastructure.DeputyInfrastructurePort;
import java.util.List;

public class DeputyService implements DeputyApplicationPort {

  private final DeputyInfrastructurePort infrastructurePort;

  public DeputyService(DeputyInfrastructurePort infrastructurePort) {
    this.infrastructurePort = infrastructurePort;
  }

  @Override
  public List<Deputy> findAll() throws DomainException {
    try {
      return infrastructurePort.findAll();
    } catch (InfrastructureException e) {
      throw new DomainException(e);
    } catch (RuntimeException e) {
      throw new DomainException("Unexpected domain service exception", e);
    }
  }
}
