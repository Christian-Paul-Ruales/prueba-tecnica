package com.ntt.data.mcsv_personacliente.domain.service.impl;

import com.ntt.data.mcsv_personacliente.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.exception.DomainException;
import com.ntt.data.mcsv_personacliente.domain.repository.IClienteRepository;
import com.ntt.data.mcsv_personacliente.domain.service.IClienteService;
import com.ntt.data.mcsv_personacliente.domain.util.ServiceUtil;
import com.ntt.data.mcsv_personacliente.domain.util.UsuarioUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final ServiceUtil serviceUtil;
    private final UsuarioUtil usuarioUtil;
    private final IClienteRepository clienteRepository;

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
            log.error("update: id no enviado para la actualizacion de informacion");
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
        log.info("Metodo delete procesado correctamente");

        return clienteDTO;
    }
}
