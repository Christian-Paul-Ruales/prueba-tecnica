package com.ntt.data.mcsv_cuentamovimientos.domain.util;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class CuentaUtil {

    private static final Logger logger = LoggerFactory.getLogger(CuentaUtil.class);

    /**
     * genera cuenta con numeros aleatorios, enviando el tamano del texto
     * */
    public String generarCuenta(int tamano){
        logger.info(String.format("Inicio metodo generar cuenta de tamano %s", tamano));
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new SecureRandom();
        int index;

        for (int i = 0; i < tamano; i++) {
            index = random.nextInt(DominioConstantes.NUMEROS.length());
            logger.info(String.format("Recorre %s, indice %s", i, index));
            stringBuilder.append(DominioConstantes.NUMEROS.charAt(index));
        }

        return stringBuilder.toString();
    }
}
