package com.ntt.data.mcsv_personacliente.domain.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDTO extends PersonaDTO{
    /**
     * La id se genera automaticamente, por esta razon el usuario no siempre va a enviarlo
     * */
    private Integer id;
    @NotNull
    @Size(min = 5, max=20, message = "El password debe tener entre 5 y 20 caracteres")
    private String contrasena;
    @NotNull(message = "Estado obligatorio")
    private Boolean estado;

}
