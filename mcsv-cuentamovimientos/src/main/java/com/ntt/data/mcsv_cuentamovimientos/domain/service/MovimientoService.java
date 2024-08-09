package com.ntt.data.mcsv_cuentamovimientos.domain.service;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.IMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    private IMovimientoRepository movimientoRepository;

    public List<MovimientoDTO> getAll(){
        return movimientoRepository.getAll();
    }

    public MovimientoDTO getById(int id){
        return movimientoRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_MOVIMIENTO_NO_ENCONTRADO, id))
        );
    }

    public MovimientoDTO save(MovimientoDTO movimientoDTO){
        return movimientoRepository.save(movimientoDTO);
    }

    public MovimientoDTO update(MovimientoDTO movimientoDTO){
        getById(movimientoDTO.getId());
        return movimientoRepository.save(movimientoDTO);
    }

    public MovimientoDTO delete(int id){
        MovimientoDTO movimientoDTO = getById(id);
        movimientoRepository.delete(id);
        return movimientoDTO;
    }

}
