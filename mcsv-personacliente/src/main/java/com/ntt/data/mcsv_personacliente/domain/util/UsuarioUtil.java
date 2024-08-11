package com.ntt.data.mcsv_personacliente.domain.util;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioUtil {
    @Autowired
    private ServiceUtil serviceUtil;

    public String generarPassword(ClienteDTO clienteDTO){
        StringBuilder contrasenaBuilder = new StringBuilder(clienteDTO.getNombre().replace(" ",""));
        contrasenaBuilder.append(clienteDTO.getContrasena());

        return serviceUtil.generarUuid(contrasenaBuilder.toString());
    }
}
