package com.github.luiguip.chamber_of_deputies_service.infrastructure.adapter;

import com.github.luiguip.chamber_of_deputies_service.domain.model.CongressPerson;
import com.github.luiguip.chamber_of_deputies_service.domain.port.infrastructure.CongressPersonPort;
import com.github.luiguip.chamber_of_deputies_service.infrastructure.deputados.client.DeputadosClient;
import com.github.luiguip.chamber_of_deputies_service.infrastructure.mapper.CongressPersonMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CongressPersonAdapter implements CongressPersonPort {

  private final DeputadosClient client;

  private final CongressPersonMapper mapper;

  public List<CongressPerson> findAll() {
    var response = client.findDeputados();
    return mapper.toDomain(response);
  }

}
