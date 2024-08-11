package com.ntt.data.mcsv_cuentamovimientos.domain.util;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import org.springframework.stereotype.Component;

@Component
public class MovimientoUtil {
    /**
     * procesar el movimiento segun su tipo, RETIRO o DEPOSITO
     * */
    public MovimientoDTO generarMovimiento(MovimientoDTO movimientoDTO, Double saldoActual){
        if(movimientoDTO.getTipoMovimiento().equals( DominioConstantes.MOVIMIENTO_RETIRO)){
            if(saldoActual < movimientoDTO.getValor() ){
                throw new DomainException(String.format(DominioConstantes.MSG_CUENTA_SALDO_INSUFICIENTE, saldoActual, movimientoDTO.getSaldo()));
            }else {
                saldoActual = saldoActual - movimientoDTO.getValor();
            }
        }else if(movimientoDTO.getTipoMovimiento().equals( DominioConstantes.MOVIMIENTO_DEPOSITO)){
            saldoActual = saldoActual + movimientoDTO.getValor();
        }else {
            throw new DomainException(String.format(DominioConstantes.MSG_MOVIMIENTO_NO_RECONOCIDO, movimientoDTO.getTipoMovimiento()));
        }
        movimientoDTO.setSaldo(saldoActual);

        return movimientoDTO;
    }
}
