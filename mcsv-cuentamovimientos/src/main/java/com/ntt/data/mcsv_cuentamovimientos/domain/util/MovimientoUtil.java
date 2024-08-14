package com.ntt.data.mcsv_cuentamovimientos.domain.util;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MovimientoUtil {
    private static final Logger logger = LoggerFactory.getLogger(MovimientoUtil.class);

    /**
     * procesar el movimiento segun su tipo, RETIRO o DEPOSITO
     * */
    public MovimientoDTO generarMovimiento(MovimientoDTO movimientoDTO, Double saldoActual){
        if(movimientoDTO.getTipoMovimiento().equals( DominioConstantes.MOVIMIENTO_RETIRO)){
            logger.info("Movimiento tipo RETIRO");
            if(saldoActual < movimientoDTO.getValor() ){
                logger.error(String.format(DominioConstantes.MSG_CUENTA_SALDO_INSUFICIENTE, saldoActual, movimientoDTO.getSaldo()));
                throw new DomainException(String.format(DominioConstantes.MSG_CUENTA_SALDO_INSUFICIENTE, saldoActual, movimientoDTO.getSaldo()));
            }else {
                saldoActual = saldoActual - movimientoDTO.getValor();
            }
        }else if(movimientoDTO.getTipoMovimiento().equals( DominioConstantes.MOVIMIENTO_DEPOSITO)){
            logger.info("Movimiento DEPOSITO");

            saldoActual = saldoActual + movimientoDTO.getValor();
        }else {
            logger.info("NO SE RECONOCE EL TIPO DE MOVIMIENTO");

            throw new DomainException(String.format(DominioConstantes.MSG_MOVIMIENTO_NO_RECONOCIDO, movimientoDTO.getTipoMovimiento()));
        }
        movimientoDTO.setSaldo(saldoActual);
        logger.info("SALDO PROCESADO");

        return movimientoDTO;
    }
}
