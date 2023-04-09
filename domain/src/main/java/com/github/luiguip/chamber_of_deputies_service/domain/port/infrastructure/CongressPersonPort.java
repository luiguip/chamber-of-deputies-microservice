package com.github.luiguip.chamber_of_deputies_service.domain.port.infrastructure;

import com.github.luiguip.chamber_of_deputies_service.domain.model.CongressPerson;
import java.util.List;

public interface CongressPersonPort {

  List<CongressPerson> findAll();
}
