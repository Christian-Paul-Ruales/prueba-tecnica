package com.ntt.data.mcsv_personacliente.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Integer id;
    private String clienteId;
    private String contrasena;
    private Boolean estado;
}
