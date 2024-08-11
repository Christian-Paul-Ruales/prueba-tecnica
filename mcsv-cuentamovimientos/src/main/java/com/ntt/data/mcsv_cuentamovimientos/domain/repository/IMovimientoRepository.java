package com.ntt.data.mcsv_cuentamovimientos.domain.repository;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IMovimientoRepository {
    List<MovimientoDTO> getAll();

    Optional<MovimientoDTO> getById(int id);

    MovimientoDTO save(MovimientoDTO movimiento);

    MovimientoDTO update(MovimientoDTO movimiento);

    void delete(int id);

    List<MovimientoDTO> getAllByCuentaId(int cuentaId);
    List<MovimientoDTO> getAllByCuentaIdBetweenTo(int cuentaId, Date fechaInicio, Date fechaFin);

}
