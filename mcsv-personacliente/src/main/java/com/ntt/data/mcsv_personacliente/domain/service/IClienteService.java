package com.ntt.data.mcsv_personacliente.domain.service;

import com.ntt.data.mcsv_personacliente.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.exception.DomainException;

import java.util.List;

public interface IClienteService {
    List<ClienteDTO> getAll();


    ClienteDTO getById(Integer id);


    ClienteDTO save(ClienteDTO clienteDTO);


    ClienteDTO update(ClienteDTO clienteDTO);


    void delete(Integer id);
}
