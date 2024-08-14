package com.ntt.data.mcsv_cuentamovimientos.domain.service;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;

import java.util.Date;
import java.util.List;

public interface IMovimientoService {

    List<MovimientoDTO> getAll();

    MovimientoDTO getById(int id);

    MovimientoDTO save(MovimientoDTO movimientoDTO);

    MovimientoDTO update(MovimientoDTO movimientoDTO);

    void delete(int id);

    List<MovimientoDTO> getAllByCuentaId(int cuentaId);


    List<MovimientoDTO> getAllBetweenToByCuentaId(int cuentaId, Date fechaInicio, Date fechaFin);
}
