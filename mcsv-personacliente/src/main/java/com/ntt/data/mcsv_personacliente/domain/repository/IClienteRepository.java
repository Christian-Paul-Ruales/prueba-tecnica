package com.ntt.data.mcsv_personacliente.domain.repository;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.persistence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository {
    List<Cliente> getAll();

    Optional<Cliente> getById(int id);

    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);

    void delete(int id);
}
