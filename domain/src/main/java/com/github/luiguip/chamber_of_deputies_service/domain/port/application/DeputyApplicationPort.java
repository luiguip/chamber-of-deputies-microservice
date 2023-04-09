package com.github.luiguip.chamber_of_deputies_service.domain.port.application;

import com.github.luiguip.chamber_of_deputies_service.domain.exception.DomainException;
import com.github.luiguip.chamber_of_deputies_service.domain.model.Deputy;
import java.util.List;

public interface DeputyApplicationPort {

  List<Deputy> findAll() throws DomainException;
}
