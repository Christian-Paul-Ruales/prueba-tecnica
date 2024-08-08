package com.ntt.data.mcsv_personacliente.web;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.service.ClienteService;
import com.ntt.data.mcsv_personacliente.persistence.entity.Cliente;
import com.ntt.data.mcsv_personacliente.persistence.mapper.ClienteMapper;
import com.ntt.data.mcsv_personacliente.persistence.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> getAll() {

        List<Cliente> lstClientes =clienteService.getAll();
        return clienteMapper.getDTOs(lstClientes);
    }

    @GetMapping("/:id")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> getById() {
        Cliente cliente = clienteService.getById()
    }
}
