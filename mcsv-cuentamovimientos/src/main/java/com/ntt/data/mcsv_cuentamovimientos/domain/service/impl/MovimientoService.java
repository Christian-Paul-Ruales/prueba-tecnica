package com.ntt.data.mcsv_cuentamovimientos.domain.service.impl;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.IMovimientoRepository;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.IMovimientoService;
import com.ntt.data.mcsv_cuentamovimientos.domain.util.MovimientoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovimientoService implements IMovimientoService {
    @Autowired
    private IMovimientoRepository movimientoRepository;
    @Autowired
    private CuentaService cuentaService;
    @Autowired
    private MovimientoUtil movimientoUtil;

    private static final Logger logger = LoggerFactory.getLogger(CuentaService.class);

    @Override
    public List<MovimientoDTO> getAll(){
        return movimientoRepository.getAll();
    }

    @Override
    public MovimientoDTO getById(int id){
        return movimientoRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_MOVIMIENTO_NO_ENCONTRADO, id))
        );
    }

    @Override
    public MovimientoDTO save(MovimientoDTO movimientoDTO){
        movimientoDTO.setFecha(new Date());
        CuentaDTO cuentaDTO = cuentaService.getById(movimientoDTO.getCuentaId());
        List<MovimientoDTO> movimientos = getAllByCuentaId(movimientoDTO.getCuentaId());
        Double saldoActual = movimientos.isEmpty() ? cuentaDTO.getSaldoInicial() : movimientos.get(movimientos.size() - 1).getSaldo();

        cuentaDTO.setSaldoActual(saldoActual);
        cuentaService.update(cuentaDTO);

        movimientoDTO = movimientoUtil.generarMovimiento(movimientoDTO,saldoActual);

        return movimientoRepository.save(movimientoDTO);
    }

    @Override
    public MovimientoDTO update(MovimientoDTO movimientoDTO){
        return movimientoRepository.update(movimientoDTO);
    }

    @Override
    public MovimientoDTO delete(int id){
        logger.info(String.format("Borrar movimiento %s", id));
        MovimientoDTO movimientoDTO = getById(id);
        movimientoRepository.delete(id);
        return movimientoDTO;
    }

    @Override
    public List<MovimientoDTO> getAllByCuentaId(int cuentaId){
        return movimientoRepository.getAllByCuentaId(cuentaId);
    }

    @Override
    public List<MovimientoDTO> getAllBetweenToByCuentaId(int cuentaId, Date fechaInicio, Date fechaFin){
        logger.info(String.format("Obtener datos por fechas entre %s y %s", fechaInicio, fechaFin));

        return movimientoRepository.getAllByCuentaIdBetweenTo(cuentaId, fechaInicio, fechaFin);
    }


}
