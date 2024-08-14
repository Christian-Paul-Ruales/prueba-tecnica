package com.ntt.data.mcsv_personacliente.domain.util;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UsuarioUtil {
    @Autowired
    private ServiceUtil serviceUtil;

    public String generarPassword(ClienteDTO clienteDTO){
        log.info("UsuarioUtil - inicio del metodo de cifrado de password");
        StringBuilder contrasenaBuilder = new StringBuilder(clienteDTO.getNombre().replace(" ",""));
        contrasenaBuilder.append(clienteDTO.getContrasena());

        return serviceUtil.generarUuid(contrasenaBuilder.toString());
    }
}
