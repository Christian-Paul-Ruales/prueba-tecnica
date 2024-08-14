package com.ntt.data.mcsv_cuentamovimientos.domain.util;

import com.ntt.data.mcsv_cuentamovimientos.client.ClienteClient;
import com.ntt.data.mcsv_cuentamovimientos.client.dto.ClienteDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Component
public class CuentaUtil {

    private final ClienteClient clienteClient;

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

    /**
     * Realiza la busqueda microservicio personacliente y obtiene el nombre
     * */
    public CuentaDTO procesarBusquedaCliente(CuentaDTO cuentaDTO){
        ClienteDTO clienteDTO = clienteClient.getById(cuentaDTO.getClienteId());
        log.info(String.format("Se realizó la consulta de información  del microservicio cliente %s desde el metodo getById", cuentaDTO.getClienteId()));
        cuentaDTO.setClienteNombre(clienteDTO.getNombre());

        return cuentaDTO;
    }
}
