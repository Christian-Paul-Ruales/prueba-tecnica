package com.ntt.data.mcsv_personacliente.web.controller;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final IClienteService clienteService;



    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> getAll() {
        log.info("Recibida la solicitud GET de todos los registros para /api/clientes/all");

        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id) {
        log.info("Recibida la solicitud GET de busqueda de un registro mediante {id} para /api/clientes");

        try {
            return new ResponseEntity<>(clienteService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            log.error("Excepcion al procesar la peticion GET con id", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO save(@Valid @RequestBody ClienteDTO clienteDTO) {
        log.info("Recibida la solicitud POST para la creacion de datos en /api/clientes");
        return clienteService.save(clienteDTO);
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody ClienteDTO clienteDTO) {
        try {
            log.info("Recibida la solicitud PUT para la actualizacion de datos en /api/clientes");
            return new ResponseEntity<>(clienteService.update(clienteDTO), HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Excepcion al procesar la peticion PUT en /api/clientes.", e);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id ) {
        try {
            log.info("Recibida la solicitud DELETE para la eliminacion de datos en /api/clientes");
            return new ResponseEntity<>(clienteService.delete(id), HttpStatus.OK);
        }catch (Exception e){
            log.error("Excepcion al procesar la peticion DELETE en /api/clientes.", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
