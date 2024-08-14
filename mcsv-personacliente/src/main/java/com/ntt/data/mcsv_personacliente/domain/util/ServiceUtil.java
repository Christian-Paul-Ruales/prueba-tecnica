package com.ntt.data.mcsv_personacliente.domain.util;

import com.ntt.data.mcsv_personacliente.persistence.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ServiceUtil {

    /**
     * Genera uuid eliminando -
     * */
    public String generarUuid(String valor){
        log.info("ServiceUtil - Metodo para generacion de uuid mediante los bytes de un texto");
        return UUID.nameUUIDFromBytes(valor.getBytes()).toString()
                .replace("-","");
    }
    /**
     * valida si el uuid es valido, devolviendo un boolean
     * **/
    public static boolean uuidValid(String uuidStr) {
        try {
            UUID uuid = UUID.fromString(uuidStr);
            return uuid.toString().equals(uuidStr);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


}
