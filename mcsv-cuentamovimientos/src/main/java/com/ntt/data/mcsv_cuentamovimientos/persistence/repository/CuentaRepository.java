package com.ntt.data.mcsv_cuentamovimientos.persistence.repository;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.ICuentaRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.crud.CuentaCrudRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import com.ntt.data.mcsv_cuentamovimientos.persistence.mapper.CuentaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class CuentaRepository implements ICuentaRepository {

    private final CuentaCrudRepository cuentaCrudRepository;
    
    @Override
    public List<CuentaDTO> getAll() {
        List<Cuenta> lstCuentas = (List<Cuenta>) cuentaCrudRepository.findAll();

        return CuentaMapper.INSTANCE.getDTOs(lstCuentas);
    }

    @Override
    public Optional<CuentaDTO> getById(int id) {

        return cuentaCrudRepository.findById(id).map(
                cuenta -> CuentaMapper.INSTANCE.getDTO(cuenta)
        );
    }

    @Override
    public CuentaDTO save(CuentaDTO cuentaDTO) {
        Cuenta cuenta  = cuentaCrudRepository.save(CuentaMapper.INSTANCE.getEntidad(cuentaDTO));
        return CuentaMapper.INSTANCE.getDTO(cuenta);
    }

    @Override
    public CuentaDTO update(CuentaDTO cuentaDTO) {

        return save(cuentaDTO);
    }

    @Override
    public void delete(int id) {
        cuentaCrudRepository.deleteById(id);
    }

    @Override
    public List<CuentaDTO> getByClienteId(int id){
        List<Cuenta> lstCuentas = cuentaCrudRepository.findByClienteId(id);
        log.info(String.format("Cliente %s se encontraron %s cuentas",id, lstCuentas.size()));
        return CuentaMapper.INSTANCE.getDTOs(lstCuentas);
    }

}
