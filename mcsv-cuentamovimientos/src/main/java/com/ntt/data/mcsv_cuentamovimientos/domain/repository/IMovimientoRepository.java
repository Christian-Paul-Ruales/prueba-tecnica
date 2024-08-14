package com.ntt.data.mcsv_cuentamovimientos.domain.repository;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IMovimientoRepository {
    List<Movimiento> getAll();

    Optional<Movimiento> getById(int id);

    Movimiento save(Movimiento movimiento);

    Movimiento update(Movimiento movimiento);

    void delete(int id);

    List<Movimiento> getAllByCuentaId(int cuentaId);
    List<Movimiento> getAllByCuentaIdBetweenTo(int cuentaId, Date fechaInicio, Date fechaFin);

}
