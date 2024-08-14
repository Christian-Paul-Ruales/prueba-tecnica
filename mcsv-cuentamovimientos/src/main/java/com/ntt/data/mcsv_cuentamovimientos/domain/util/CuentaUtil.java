package com.ntt.data.mcsv_cuentamovimientos.domain.util;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Slf4j
@Component
public class CuentaUtil {


    /**
     * genera cuenta con numeros aleatorios, enviando el tamano del texto
     * */
    public String generarCuenta(int tamano){
        log.info(String.format("Inicio metodo generar cuenta de tamano %s", tamano));
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new SecureRandom();
        int index;

        for (int i = 0; i < tamano; i++) {
            index = random.nextInt(DominioConstantes.NUMEROS.length());
            log.info(String.format("Recorre %s, indice %s", i, index));
            stringBuilder.append(DominioConstantes.NUMEROS.charAt(index));
        }

        return stringBuilder.toString();
    }
}
