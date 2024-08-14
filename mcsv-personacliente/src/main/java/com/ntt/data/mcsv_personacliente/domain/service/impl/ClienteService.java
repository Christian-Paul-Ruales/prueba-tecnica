package com.ntt.data.mcsv_personacliente.domain.service.impl;

import com.ntt.data.mcsv_personacliente.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.exception.DomainException;
import com.ntt.data.mcsv_personacliente.domain.repository.IClienteRepository;
import com.ntt.data.mcsv_personacliente.domain.service.IClienteService;
import com.ntt.data.mcsv_personacliente.domain.util.ServiceUtil;
import com.ntt.data.mcsv_personacliente.domain.util.UsuarioUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private UsuarioUtil usuarioUtil;
    @Autowired
    private IClienteRepository clienteRepository;

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Override
    public List<ClienteDTO> getAll() {
        return clienteRepository.getAll();
    }

    @Override
    public ClienteDTO getById(Integer id)  {

        return clienteRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_ERROR_BUSQUEDA_PERSONA, id))
                );
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        clienteDTO.setPersonaId(serviceUtil.generarUuid(clienteDTO.getNombre()));
        String contrasena = usuarioUtil.generarPassword(clienteDTO);
        clienteDTO.setContrasena(contrasena);
        return clienteRepository.save(clienteDTO);
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        if(clienteDTO.getId() == null){
            logger.error("update: id no enviado para la actualizacion de informacion");
            throw new DomainException(String.format(DominioConstantes.MSG_ERROR_DATA_REQUERIDA, "ID CLIENTE"));
        }
        getById(clienteDTO.getId());

        String contrasena = usuarioUtil.generarPassword(clienteDTO);
        clienteDTO.setContrasena(contrasena);

        return clienteRepository.save(clienteDTO);
    }

    @Override
    public ClienteDTO delete(Integer id) {
        ClienteDTO clienteDTO = getById(id);
        clienteRepository.delete(id);
        logger.info("Metodo delete procesado correctamente");

        return clienteDTO;
    }
}
