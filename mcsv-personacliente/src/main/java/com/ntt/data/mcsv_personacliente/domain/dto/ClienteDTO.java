package com.ntt.data.mcsv_personacliente.domain.dto;


import lombok.Data;

@Data
public class ClienteDTO extends PersonaDTO{
    private Integer id;
    private String contrasena;
    private Boolean estado;

}
