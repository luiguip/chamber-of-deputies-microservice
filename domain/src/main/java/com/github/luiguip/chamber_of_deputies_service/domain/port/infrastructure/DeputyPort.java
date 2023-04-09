package com.github.luiguip.chamber_of_deputies_service.domain.port.infrastructure;

import com.github.luiguip.chamber_of_deputies_service.domain.exception.InfrastructureException;
import com.github.luiguip.chamber_of_deputies_service.domain.model.Deputy;
import java.util.List;

public interface DeputyPort {

  List<Deputy> findAll() throws InfrastructureException;
}
