package com.ntt.data.mcsv_cuentamovimientos.persistence.crud;

import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

public interface CuentaCrudRepository extends CrudRepository<Cuenta, Integer> {

}
