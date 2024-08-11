package com.ntt.data.mcsv_personacliente.domain.service;

import com.ntt.data.mcsv_personacliente.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.exception.DomainException;
import com.ntt.data.mcsv_personacliente.domain.repository.IClienteRepository;
import com.ntt.data.mcsv_personacliente.domain.util.ServiceUtil;
import com.ntt.data.mcsv_personacliente.domain.util.UsuarioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private UsuarioUtil usuarioUtil;
    @Autowired
    private IClienteRepository clienteRepository;


    public List<ClienteDTO> getAll() {
        return clienteRepository.getAll();
    }


    public ClienteDTO getById(Integer id)  {

        return clienteRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_ERROR_BUSQUEDA_PERSONA, id))
                );
    }


    public ClienteDTO save(ClienteDTO clienteDTO) {
        clienteDTO.setPersonaId(serviceUtil.generarUuid(clienteDTO.getNombre()));
        String contrasena = usuarioUtil.generarPassword(clienteDTO);
        clienteDTO.setContrasena(contrasena);
        return clienteRepository.save(clienteDTO);
    }


    public ClienteDTO update(ClienteDTO clienteDTO) {
        if(clienteDTO.getId() == null){
            throw new DomainException(String.format(DominioConstantes.MSG_ERROR_DATA_REQUERIDA, "ID CLIENTE"));
        }
        getById(clienteDTO.getId());

        String contrasena = usuarioUtil.generarPassword(clienteDTO);
        clienteDTO.setContrasena(contrasena);

        return clienteRepository.save(clienteDTO);
    }


    public ClienteDTO delete(Integer id) {
        ClienteDTO clienteDTO = getById(id);
        clienteRepository.delete(id);
        return clienteDTO;
    }
}
