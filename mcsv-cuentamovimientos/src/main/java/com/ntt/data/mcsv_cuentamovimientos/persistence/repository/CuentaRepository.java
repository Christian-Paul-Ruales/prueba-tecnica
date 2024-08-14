package com.ntt.data.mcsv_cuentamovimientos.persistence.repository;

import com.ntt.data.mcsv_cuentamovimientos.domain.repository.ICuentaRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.crud.CuentaCrudRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class CuentaRepository implements ICuentaRepository {

    private final CuentaCrudRepository cuentaCrudRepository;

    @Override
    public List<Cuenta> getAll() {
        return (List<Cuenta>) cuentaCrudRepository.findAll();
    }

    @Override
    public Optional<Cuenta> getById(int id) {

        return cuentaCrudRepository.findById(id);
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentaCrudRepository.save(cuenta);
    }

    @Override
    public Cuenta update(Cuenta cuenta) {

        return save(cuenta);
    }

    @Override
    public void delete(int id) {
        cuentaCrudRepository.deleteById(id);
    }

    @Override
    public List<Cuenta> getByClienteId(int id){
        log.info(String.format("Busqueda de cuentas del cliente %s ",id));
        return cuentaCrudRepository.findByClienteId(id);
    }

}
