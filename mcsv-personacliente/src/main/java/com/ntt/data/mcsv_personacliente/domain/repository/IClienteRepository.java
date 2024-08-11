package com.ntt.data.mcsv_personacliente.domain.repository;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository {
    List<ClienteDTO> getAll();

    Optional<ClienteDTO> getById(int id);

    ClienteDTO save(ClienteDTO clienteDTO);
    ClienteDTO update(ClienteDTO clienteDTO);

    void delete(int id);
}
