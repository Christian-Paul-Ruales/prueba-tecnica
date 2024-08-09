package com.ntt.data.mcsv_cuentamovimientos.domain.service;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private ICuentaRepository cuentaRepository;

    public List<CuentaDTO> getAll(){
        return cuentaRepository.getAll();
    }

    public CuentaDTO getById(int id){
        return cuentaRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_CUENTA_NO_ENCONTRADO, id))
        );
    }

    public CuentaDTO save(CuentaDTO cuentaDTO){
        return cuentaRepository.save(cuentaDTO);
    }

    public CuentaDTO update(CuentaDTO cuentaDTO){
        getById(cuentaDTO.getId());
        return cuentaRepository.save(cuentaDTO);
    }                                                                                   

    public CuentaDTO delete(int id){
        CuentaDTO cuentaDTO = getById(id);
        cuentaRepository.delete(id);
        return cuentaDTO;
    }
}
