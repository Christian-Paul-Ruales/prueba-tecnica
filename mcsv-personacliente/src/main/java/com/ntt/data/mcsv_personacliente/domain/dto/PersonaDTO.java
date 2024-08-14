package com.ntt.data.mcsv_personacliente.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonaDTO {
    private String personaId;
    @NotNull
    @NotBlank
    private String nombre;

    @NotNull
    @NotBlank
    @Size(max = 1, message = "Genero en mayuscula, M o F")
    private String genero;
    @NotNull
    private Integer edad;
    @NotNull
    @Size(min = 10, max = 13, message = "Identificacion entre 10 y 13 caracteres")
    private String identificacion;

    @Size(max=100, message = "La dirección tiene un tamaño maximo de 100 caracteres")
    private String direccion;

    @Size(max=10, min = 10, message = "Telefono debe contener entre 9 y 10 digitos")
    private String telefono;


}
