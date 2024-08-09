package com.ntt.data.mcsv_cuentamovimientos.persistence.crud;

import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;
import org.springframework.data.repository.CrudRepository;

public interface MovimientoCrudRepository extends CrudRepository<Movimiento, Integer> {

}
