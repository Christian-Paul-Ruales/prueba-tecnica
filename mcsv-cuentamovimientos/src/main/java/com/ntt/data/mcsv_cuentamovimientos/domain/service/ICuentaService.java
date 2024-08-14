package com.ntt.data.mcsv_cuentamovimientos.domain.service;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import java.util.List;

public interface ICuentaService {
    List<CuentaDTO> getAll();

    CuentaDTO getById(int id);

    CuentaDTO save(CuentaDTO cuentaDTO);

    CuentaDTO update(CuentaDTO cuentaDTO);

    CuentaDTO delete(int id);

    List<CuentaDTO> getByClienteId(int id);
}
