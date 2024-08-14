package com.ntt.data.mcsv_personacliente.domain.util;

import com.ntt.data.mcsv_personacliente.persistence.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ServiceUtil {
    private static final Logger logger = LoggerFactory.getLogger(ServiceUtil.class);

    /**
     * Genera uuid eliminando -
     * */
    public String generarUuid(String valor){
        logger.info("ServiceUtil - Metodo para generacion de uuid mediante los bytes de un texto");
        return UUID.nameUUIDFromBytes(valor.getBytes()).toString()
                .replace("-","");
    }




}
