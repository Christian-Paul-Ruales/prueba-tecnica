package com.ntt.data.mcsv_cuentamovimientos.web.controller;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.ICuentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final ICuentaService cuentaService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CuentaDTO>> getAll(){
        log.info("Recibida la solicitud GET de todos los registros para /api/cuentas/all");

        try {
            return new ResponseEntity<>(cuentaService.getAll(), HttpStatus.OK);
        }catch (Exception e){
            log.error("Excepcion al procesar la peticion GET all", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        log.info("Recibida la solicitud GET de busqueda de un registro mediante {id} para /api/cuentas");

        try {
            return new ResponseEntity<>(cuentaService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            log.error("Excepcion al procesar la peticion GET con id", e);
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CuentaDTO save(@Valid @RequestBody CuentaDTO cuentaDTO){
        log.info("Recibida la solicitud POST para la creacion de datos en /api/cuentas");

        return cuentaService.save(cuentaDTO);
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody CuentaDTO cuentaDTO){
        try {
            log.info("Recibida la solicitud PUT para la actualizacion de datos en /api/cuentas");
            return new ResponseEntity<>(cuentaService.update(cuentaDTO), HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Excepcion al procesar la peticion PUT en /api/cuentas.", e);
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        try {
            log.info("Recibida la solicitud DELETE para la eliminacion de datos en /api/cuentas");
            cuentaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.error("Excepcion al procesar la peticion DELETE en /api/cuentas.", e);
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }


}
