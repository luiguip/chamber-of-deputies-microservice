package com.github.luiguip.chamber_of_deputies_service.infrastructure.adapter;

import com.github.luiguip.chamber_of_deputies_service.domain.exception.InfrastructureException;
import com.github.luiguip.chamber_of_deputies_service.domain.model.Deputy;
import com.github.luiguip.chamber_of_deputies_service.domain.port.infrastructure.DeputyInfrastructurePort;
import com.github.luiguip.chamber_of_deputies_service.infrastructure.deputados.client.DeputadosClient;
import com.github.luiguip.chamber_of_deputies_service.infrastructure.mapper.DeputyMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeputyAdapter implements DeputyInfrastructurePort {

  private final DeputadosClient client;

  private final DeputyMapper mapper;

  public List<Deputy> findAll() throws InfrastructureException {
    try {
      var response = client.findDeputados();
      return mapper.toDomain(response);
    } catch (RuntimeException e) {
      throw new InfrastructureException("Unexpected adapter exception", e);
    }
  }

}
