package com.ntt.data.mcsv_personacliente.domain.util;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioUtil {
    @Autowired
    private ServiceUtil serviceUtil;
    private static final Logger logger = LoggerFactory.getLogger(ServiceUtil.class);

    public String generarPassword(ClienteDTO clienteDTO){
        logger.info("UsuarioUtil - inicio del metodo de cifrado de password");
        StringBuilder contrasenaBuilder = new StringBuilder(clienteDTO.getNombre().replace(" ",""));
        contrasenaBuilder.append(clienteDTO.getContrasena());

        return serviceUtil.generarUuid(contrasenaBuilder.toString());
    }
}
