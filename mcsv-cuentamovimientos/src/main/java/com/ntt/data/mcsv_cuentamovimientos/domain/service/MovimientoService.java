package com.ntt.data.mcsv_cuentamovimientos.domain.service;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.IMovimientoRepository;
import com.ntt.data.mcsv_cuentamovimientos.domain.util.MovimientoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    private IMovimientoRepository movimientoRepository;
    @Autowired
    private CuentaService cuentaService;
    @Autowired
    private MovimientoUtil movimientoUtil;

    public List<MovimientoDTO> getAll(){
        return movimientoRepository.getAll();
    }

    public MovimientoDTO getById(int id){
        return movimientoRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_MOVIMIENTO_NO_ENCONTRADO, id))
        );
    }

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

    public MovimientoDTO update(MovimientoDTO movimientoDTO){
        getById(movimientoDTO.getId());
        return movimientoRepository.update(movimientoDTO);
    }

    public MovimientoDTO delete(int id){
        MovimientoDTO movimientoDTO = getById(id);
        movimientoRepository.delete(id);
        return movimientoDTO;
    }

    public List<MovimientoDTO> getAllByCuentaId(int cuentaId){
        return movimientoRepository.getAllByCuentaId(cuentaId);
    }

    public List<MovimientoDTO> getAllBetweenToByCuentaId(int cuentaId, Date fechaInicio, Date fechaFin){
        return movimientoRepository.getAllByCuentaIdBetweenTo(cuentaId, fechaInicio, fechaFin);
    }


}
