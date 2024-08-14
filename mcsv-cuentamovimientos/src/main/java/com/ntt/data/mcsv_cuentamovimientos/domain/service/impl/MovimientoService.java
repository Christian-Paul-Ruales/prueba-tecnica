package com.ntt.data.mcsv_cuentamovimientos.domain.service.impl;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.IMovimientoRepository;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.IMovimientoService;
import com.ntt.data.mcsv_cuentamovimientos.domain.util.MovimientoUtil;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;
import com.ntt.data.mcsv_cuentamovimientos.persistence.mapper.MovimientoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MovimientoService implements IMovimientoService {


    private final IMovimientoRepository movimientoRepository;
    private final CuentaService cuentaService;
    private final MovimientoUtil movimientoUtil;
    private final MovimientoMapper movimientoMapper;

    @Override
    public List<MovimientoDTO> getAll(){
        return movimientoMapper.getDTOs(movimientoRepository.getAll());
    }

    @Override
    public MovimientoDTO getById(int id){
        Movimiento movimiento = movimientoRepository.getById(id)
            .orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_MOVIMIENTO_NO_ENCONTRADO, id))
            );

        return movimientoMapper.getDTO(movimiento);
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

        Movimiento movimiento = movimientoRepository.save(movimientoMapper.getEntidad(movimientoDTO));
        return movimientoMapper.getDTO(movimiento);
    }

    @Override
    public MovimientoDTO update(MovimientoDTO movimientoDTO){
        movimientoDTO.setSaldo(movimientoDTO.getSaldo() == null ? movimientoDTO.getValor() : movimientoDTO.getSaldo());
        Movimiento movimiento = movimientoMapper.getEntidad(movimientoDTO);

        return movimientoMapper.getDTO(movimientoRepository.update(movimiento));
    }

    @Override
    public void delete(int id){
        log.info(String.format("Borrar movimiento %s", id));

        movimientoRepository.delete(id);
    }

    @Override
    public List<MovimientoDTO> getAllByCuentaId(int cuentaId){
        return movimientoMapper.getDTOs(movimientoRepository.getAllByCuentaId(cuentaId));
    }

    @Override
    public List<MovimientoDTO> getAllBetweenToByCuentaId(int cuentaId, Date fechaInicio, Date fechaFin){
        log.info(String.format("Obtener datos por fechas entre %s y %s", fechaInicio, fechaFin));

        return movimientoMapper.getDTOs(movimientoRepository.getAllByCuentaIdBetweenTo(cuentaId, fechaInicio, fechaFin));
    }


}
