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
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;




    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> getAll() {
        return clienteService.getAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(clienteService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO save(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.save(clienteDTO);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody ClienteDTO clienteDTO) {
        try {
            return new ResponseEntity<>(clienteService.update(clienteDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id ) {
        try {
            return new ResponseEntity<>(clienteService.delete(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


}
