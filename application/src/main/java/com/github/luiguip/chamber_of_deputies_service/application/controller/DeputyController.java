package com.github.luiguip.chamber_of_deputies_service.application.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.github.luiguip.chamber_of_deputies_service.application.adapter.DeputyApplicationAdapter;
import com.github.luiguip.chamber_of_deputies_service.application.model.DeputyDto;
import com.github.luiguip.chamber_of_deputies_service.domain.exception.ApplicationException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/deputies",
    produces = APPLICATION_JSON_VALUE)
public class DeputyController {

  private final DeputyApplicationAdapter adapter;

  @GetMapping
  public List<DeputyDto> findAll() throws ApplicationException {
    return adapter.findAll();
  }
}
