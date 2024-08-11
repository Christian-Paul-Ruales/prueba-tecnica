package com.ntt.data.mcsv_cuentamovimientos.domain.util;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CuentaUtil {

    /**
     * genera cuenta con numeros aleatorios, enviando el tamano del texto
     * */
    public String generarCuenta(int tamano){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < tamano; i++) {
            stringBuilder.append(random.nextInt(DominioConstantes.NUMEROS.length()));
        }

        return stringBuilder.toString();
    }
}
