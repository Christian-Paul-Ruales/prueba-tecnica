package com.ntt.data.mcsv_personacliente.domain.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ServiceUtil {
    /**
     * Genera uuid eliminando -
     * */
    public String generarUuid(String valor){
        return UUID.nameUUIDFromBytes(valor.getBytes()).toString()
                .replace("-","");
    }




}
