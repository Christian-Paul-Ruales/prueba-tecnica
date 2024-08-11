package com.ntt.data.mcsv_cuentamovimientos.domain.repository;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;

import java.util.List;
import java.util.Optional;

public interface ICuentaRepository {
    List<CuentaDTO> getAll();

    Optional<CuentaDTO> getById(int id);

    CuentaDTO save(CuentaDTO cuenta);
    CuentaDTO update(CuentaDTO cuenta);

    void delete(int id);

    List<CuentaDTO> getByClienteId(int clienteId);

}
