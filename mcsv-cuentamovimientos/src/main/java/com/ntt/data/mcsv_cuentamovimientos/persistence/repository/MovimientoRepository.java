package com.ntt.data.mcsv_cuentamovimientos.persistence.repository;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.IMovimientoRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.crud.MovimientoCrudRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;
import com.ntt.data.mcsv_cuentamovimientos.persistence.mapper.MovimientoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public class MovimientoRepository implements IMovimientoRepository {
    @Autowired
    private MovimientoCrudRepository movimientoCrudRepository;



    @Override
    public List<MovimientoDTO> getAll() {
        List<Movimiento> lstMovimientos = (List<Movimiento>) movimientoCrudRepository.findAll();
        return MovimientoMapper.INSTANCE.getDTOs(lstMovimientos);
    }

    @Override
    public Optional<MovimientoDTO> getById(int id) {
        return movimientoCrudRepository.findById(id).map(
                movimiento -> MovimientoMapper.INSTANCE.getDTO(movimiento)
        );
    }

    @Override
    public MovimientoDTO save(MovimientoDTO movimientoDTO) {
        Movimiento movimiento = movimientoCrudRepository.save(MovimientoMapper.INSTANCE.getEntidad(movimientoDTO));
        return MovimientoMapper.INSTANCE.getDTO(movimiento);
    }

    @Override
    public MovimientoDTO update(MovimientoDTO movimiento) {
        return save(movimiento);
    }

    @Override
    public void delete(int id) {
        movimientoCrudRepository.deleteById(id);
    }

    @Override
    public List<MovimientoDTO> getAllByCuentaId(int cuentaId){
        List<Movimiento> lstMovimientos = movimientoCrudRepository.findByCuentaIdByOrderByIdAsc(cuentaId);
        return MovimientoMapper.INSTANCE.getDTOs(lstMovimientos);
    }

    @Override
    public List<MovimientoDTO> getAllByCuentaIdBetweenTo(int cuentaId, Date fechaInicio, Date fechaFin){
        List<Movimiento> lstMovimientos = movimientoCrudRepository.findByCuentaIdBetweenToByOrderByIdAsc(cuentaId, fechaInicio, fechaFin);
        return MovimientoMapper.INSTANCE.getDTOs(lstMovimientos);

    }
}
