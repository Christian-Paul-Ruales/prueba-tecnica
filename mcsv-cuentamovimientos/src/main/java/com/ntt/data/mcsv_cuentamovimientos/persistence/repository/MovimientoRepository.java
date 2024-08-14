package com.ntt.data.mcsv_cuentamovimientos.persistence.repository;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.IMovimientoRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.crud.MovimientoCrudRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;
import com.ntt.data.mcsv_cuentamovimientos.persistence.mapper.MovimientoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MovimientoRepository implements IMovimientoRepository {

    private final MovimientoCrudRepository movimientoCrudRepository;

    @Override
    public List<Movimiento> getAll() {
        return (List<Movimiento>) movimientoCrudRepository.findAll();
    }

    @Override
    public Optional<Movimiento> getById(int id) {
        return movimientoCrudRepository.findById(id);
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return movimientoCrudRepository.save(movimiento);
    }

    @Override
    public Movimiento update(Movimiento movimiento) {
        return save(movimiento);
    }

    @Override
    public void delete(int id) {
        movimientoCrudRepository.deleteById(id);
    }

    @Override
    public List<Movimiento> getAllByCuentaId(int cuentaId){
        return movimientoCrudRepository.findByCuentaIdByOrderByIdAsc(cuentaId);
    }

    @Override
    public List<Movimiento> getAllByCuentaIdBetweenTo(int cuentaId, Date fechaInicio, Date fechaFin){
        log.info("Inicio metodo buscando cuentas por id entre fechas");

        return movimientoCrudRepository.findByCuentaIdBetweenToByOrderByIdAsc(cuentaId, fechaInicio, fechaFin);

    }
}
