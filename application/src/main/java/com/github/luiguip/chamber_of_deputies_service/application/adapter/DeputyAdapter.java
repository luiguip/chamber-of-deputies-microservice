package com.github.luiguip.chamber_of_deputies_service.application.adapter;

import com.github.luiguip.chamber_of_deputies_service.application.mapper.DeputyMapper;
import com.github.luiguip.chamber_of_deputies_service.application.model.DeputyDto;
import com.github.luiguip.chamber_of_deputies_service.domain.exception.ApplicationException;
import com.github.luiguip.chamber_of_deputies_service.domain.exception.DomainException;
import com.github.luiguip.chamber_of_deputies_service.domain.port.application.DeputyApplicationPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeputyAdapter {

  private final DeputyApplicationPort adapter;

  private final DeputyMapper mapper;

  public List<DeputyDto> findAll() throws ApplicationException {
    try {
      var deputies = adapter.findAll();
      return mapper.toDto(deputies);
    } catch (DomainException e) {
      throw new ApplicationException(e);
    }

  }
}
