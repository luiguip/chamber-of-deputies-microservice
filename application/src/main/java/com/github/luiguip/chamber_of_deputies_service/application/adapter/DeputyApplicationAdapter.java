package com.github.luiguip.chamber_of_deputies_service.application.adapter;

import com.github.luiguip.chamber_of_deputies_service.application.mapper.DeputyDtoMapper;
import com.github.luiguip.chamber_of_deputies_service.application.model.DeputyDto;
import com.github.luiguip.chamber_of_deputies_service.domain.exception.ApplicationException;
import com.github.luiguip.chamber_of_deputies_service.domain.exception.DomainException;
import com.github.luiguip.chamber_of_deputies_service.domain.port.application.DeputyApplicationPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeputyApplicationAdapter {

  private final DeputyApplicationPort adapter;

  private final DeputyDtoMapper mapper;

  public List<DeputyDto> findAll() throws ApplicationException {
    try {
      var deputies = adapter.findAll();
      return mapper.toDto(deputies);
    } catch (DomainException e) {
      throw new ApplicationException(e);
    }

  }
}
