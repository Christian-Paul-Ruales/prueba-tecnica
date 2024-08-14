package com.ntt.data.mcsv_personacliente.persistence.repository;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.repository.IClienteRepository;
import com.ntt.data.mcsv_personacliente.persistence.crud.ClienteCrudRepository;
import com.ntt.data.mcsv_personacliente.persistence.entity.Cliente;
import com.ntt.data.mcsv_personacliente.persistence.mapper.ClienteMapper;
import com.ntt.data.mcsv_personacliente.web.controller.ClienteController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements IClienteRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    private static final Logger logger = LoggerFactory.getLogger(ClienteRepository.class);

    @Override
    public List<ClienteDTO> getAll() {
        List<Cliente> lstClientes = (List<Cliente>) clienteCrudRepository.findAll();

        logger.info(
                new StringBuilder("Metodo getAll: numero de datos a retornar ")
                        .append(lstClientes.size()).toString()
                );

        return ClienteMapper.INSTANCE.getDTOs(lstClientes);
    }

    @Override
    public Optional<ClienteDTO> getById(int id) {
        logger.info(
                new StringBuilder("Metodo getById: id enviada  ")
                        .append(id).toString()
        );
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

        logger.info(
                new StringBuilder("Metodo delete: id enviada  ")
                        .append(id).toString()
        );
        clienteCrudRepository.deleteById(id);
    }
}
