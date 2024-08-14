package com.ntt.data.mcsv_personacliente.persistence.repository;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.repository.IClienteRepository;
import com.ntt.data.mcsv_personacliente.persistence.crud.ClienteCrudRepository;
import com.ntt.data.mcsv_personacliente.persistence.entity.Cliente;
import com.ntt.data.mcsv_personacliente.persistence.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Repository
public class ClienteRepository implements IClienteRepository {

    private final ClienteCrudRepository clienteCrudRepository;


    @Override
    public List<Cliente> getAll() {

        log.info("Metodo getAll: en repositorio ");

        return  (List<Cliente>) clienteCrudRepository.findAll();
    }

    @Override
    public Optional<Cliente> getById(int id) {
        log.info(
                new StringBuilder("Metodo getById: id enviada  ")
                        .append(id).toString()
        );
        return clienteCrudRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteCrudRepository.save(cliente);

    }

    @Override
    public Cliente update(Cliente cliente) {
        return save(cliente);
    }

    @Override
    public void delete(int id) {

        log.info(
                new StringBuilder("Metodo delete: id enviada  ")
                        .append(id).toString()
        );
        clienteCrudRepository.deleteById(id);
    }
}
