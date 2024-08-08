package com.ntt.data.mcsv_personacliente.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO {
    private Integer id;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String dirección;
    private String teléfono;
}
