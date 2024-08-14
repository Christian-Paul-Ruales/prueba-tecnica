package com.ntt.data.mcsv_cuentamovimientos.domain.util;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ServiceUtil {
    private static final Logger logger = LoggerFactory.getLogger(ServiceUtil.class);

    public Date convertiStringAFecha(String fechaString, String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaString);
        } catch (ParseException e) {
            logger.error(String.format("NO SE PUDO CONVERTIR EL STRING %s A FECHA, PATTERN SOLICITADO %S", fecha, pattern), e);
            throw new RuntimeException(String.format(DominioConstantes.MSG_ERROR_CONVERSION, fechaString));
        }
        return  fecha;

    }
}
