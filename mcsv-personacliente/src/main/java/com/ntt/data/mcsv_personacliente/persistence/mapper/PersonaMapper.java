package com.ntt.data.mcsv_personacliente.persistence.mapper;

import com.ntt.data.mcsv_personacliente.domain.dto.PersonaDTO;
import com.ntt.data.mcsv_personacliente.persistence.entity.Persona;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    Persona getEntidad(PersonaDTO personaDTO);

    @InheritInverseConfiguration
    PersonaDTO getDTO(Persona persona);
}
