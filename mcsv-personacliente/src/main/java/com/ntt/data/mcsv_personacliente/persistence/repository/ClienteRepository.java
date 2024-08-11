package com.ntt.data.mcsv_personacliente.persistence.repository;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.repository.IClienteRepository;
import com.ntt.data.mcsv_personacliente.persistence.crud.ClienteCrudRepository;
import com.ntt.data.mcsv_personacliente.persistence.entity.Cliente;
import com.ntt.data.mcsv_personacliente.persistence.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements IClienteRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Override
    public List<ClienteDTO> getAll() {
        List<Cliente> lstClientes = (List<Cliente>) clienteCrudRepository.findAll();

        return ClienteMapper.INSTANCE.getDTOs(lstClientes);
    }

    @Override
    public Optional<ClienteDTO> getById(int id) {
        return clienteCrudRepository.findById(id).map(
                cliente -> ClienteMapper.INSTANCE.getDTO(cliente)
        );
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = clienteCrudRepository.save(ClienteMapper.INSTANCE.getEntidad(clienteDTO));
        return ClienteMapper.INSTANCE.getDTO(cliente);
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        return save(clienteDTO);
    }

    @Override
    public void delete(int id) {
        clienteCrudRepository.deleteById(id);
    }
}
