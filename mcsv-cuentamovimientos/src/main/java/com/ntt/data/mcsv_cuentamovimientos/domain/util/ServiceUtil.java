package com.ntt.data.mcsv_cuentamovimientos.domain.util;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class ServiceUtil {

    public Date convertiStringAFecha(String fechaString, String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaString);
        } catch (ParseException e) {
            log.error(String.format("NO SE PUDO CONVERTIR EL STRING %s A FECHA, PATTERN SOLICITADO %S", fecha, pattern), e);
            throw new RuntimeException(String.format(DominioConstantes.MSG_ERROR_CONVERSION, fechaString));
        }
        return  fecha;

    }
}
