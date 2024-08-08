package com.ntt.data.mcsv_personacliente.domain.service;

import com.ntt.data.mcsv_personacliente.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_personacliente.domain.exception.ServiceException;
import com.ntt.data.mcsv_personacliente.persistence.crud.ClienteCrudRepository;
import com.ntt.data.mcsv_personacliente.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService implements IAbstractService<Cliente, Integer> {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Override
    public List<Cliente> getAll() {
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    @Override
    public Cliente getById(Integer id)  {

        return clienteCrudRepository.findById(id).
                orElseThrow( () -> new ServiceException(String.format(DominioConstantes.MSG_ERROR_BUSQUEDA_PERSONA, id))
                );
    }

    @Override
    public Cliente save(Cliente o) {

        return clienteCrudRepository.save(o);
    }

    @Override
    public Cliente update(Cliente o) {
        if(o.getId() == null){
            throw new ServiceException(String.format(DominioConstantes.MSG_ERROR_DATA_REQUERIDA, "ID CLIENTE"));
        }
        Cliente cliente = getById(o.getId());

        return clienteCrudRepository.save(cliente);
    }

    @Override
    public Cliente delete(Cliente o) {
        clienteCrudRepository.delete(o);
        return o;
    }
}
