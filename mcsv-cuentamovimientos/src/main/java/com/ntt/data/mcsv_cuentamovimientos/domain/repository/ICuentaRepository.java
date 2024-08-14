package com.ntt.data.mcsv_cuentamovimientos.domain.repository;

import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;

import java.util.List;
import java.util.Optional;

public interface ICuentaRepository {
    List<Cuenta> getAll();

    Optional<Cuenta> getById(int id);

    Cuenta save(Cuenta cuenta);
    Cuenta update(Cuenta cuenta);

    void delete(int id);

    List<Cuenta> getByClienteId(int clienteId);

}
