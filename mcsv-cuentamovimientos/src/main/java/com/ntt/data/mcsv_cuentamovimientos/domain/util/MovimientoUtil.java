package com.ntt.data.mcsv_cuentamovimientos.domain.util;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MovimientoUtil {

    /**
     * procesar el movimiento segun su tipo, RETIRO o DEPOSITO
     * */
    public MovimientoDTO generarMovimiento(MovimientoDTO movimientoDTO, Double saldoActual){
        if(movimientoDTO.getTipoMovimiento().equals( DominioConstantes.MOVIMIENTO_RETIRO)){
            log.info("Movimiento tipo RETIRO");
            if(saldoActual < movimientoDTO.getValor() ){
                log.error(String.format(DominioConstantes.MSG_CUENTA_SALDO_INSUFICIENTE, saldoActual, movimientoDTO.getSaldo()));
                throw new DomainException(String.format(DominioConstantes.MSG_CUENTA_SALDO_INSUFICIENTE, saldoActual, movimientoDTO.getSaldo()));
            }else {
                saldoActual = saldoActual - movimientoDTO.getValor();
            }
        }else if(movimientoDTO.getTipoMovimiento().equals( DominioConstantes.MOVIMIENTO_DEPOSITO)){
            log.info("Movimiento DEPOSITO");

            saldoActual = saldoActual + movimientoDTO.getValor();
        }else {
            log.info("NO SE RECONOCE EL TIPO DE MOVIMIENTO");

            throw new DomainException(String.format(DominioConstantes.MSG_MOVIMIENTO_NO_RECONOCIDO, movimientoDTO.getTipoMovimiento()));
        }
        movimientoDTO.setSaldo(saldoActual);
        log.info("SALDO PROCESADO");

        return movimientoDTO;
    }
}
