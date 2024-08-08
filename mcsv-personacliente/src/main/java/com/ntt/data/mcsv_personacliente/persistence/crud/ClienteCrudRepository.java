package com.ntt.data.mcsv_personacliente.persistence.crud;

import com.ntt.data.mcsv_personacliente.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer> {

}
