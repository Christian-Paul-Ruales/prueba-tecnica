package com.ntt.data.mcsv_personacliente.web.controller;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.service.ClienteService;
import com.ntt.data.mcsv_personacliente.persistence.entity.Cliente;
import com.ntt.data.mcsv_personacliente.persistence.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id) {

        try {
            Cliente cliente = clienteService.getById(id);
            ClienteDTO clienteDTO = clienteMapper.getDTO(cliente);

            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO save(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.getEntidad(clienteDTO);
        return clienteMapper.getDTO(clienteService.save(cliente));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO update(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.getEntidad(clienteDTO);
        return clienteMapper.getDTO(clienteService.save(cliente));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id ) {
        try {
            Cliente cliente = clienteService.delete(id);
            ClienteDTO clienteDTO = clienteMapper.getDTO(cliente);

            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


}
