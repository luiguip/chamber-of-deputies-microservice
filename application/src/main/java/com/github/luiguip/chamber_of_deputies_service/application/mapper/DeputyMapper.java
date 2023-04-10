package com.github.luiguip.chamber_of_deputies_service.application.mapper;

import com.github.luiguip.chamber_of_deputies_service.application.model.DeputyDto;
import com.github.luiguip.chamber_of_deputies_service.domain.model.Deputy;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = ComponentModel.SPRING)
public interface DeputyMapper {

  DeputyDto toDto(Deputy deputy);

  List<DeputyDto> toDto(List<Deputy> deputy);
}
