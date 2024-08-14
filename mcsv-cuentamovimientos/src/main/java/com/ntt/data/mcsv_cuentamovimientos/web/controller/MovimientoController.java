package com.ntt.data.mcsv_cuentamovimientos.web.controller;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.IMovimientoRepository;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.IMovimientoService;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.impl.MovimientoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private IMovimientoService movimientoService;

    private static final Logger logger = LoggerFactory.getLogger(MovimientoController.class);


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MovimientoDTO> getAll(){
        logger.info("Recibida la solicitud GET de todos los registros para /api/movimientos/all");

        return movimientoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        logger.info("Recibida la solicitud GET de busqueda de un registro mediante {id} para /api/movimientos");

        try {
            return new ResponseEntity<>(movimientoService.getById(id), HttpStatus.OK);
        }catch (Exception e){
            logger.error("Excepcion al procesar la peticion GET con id... ", e);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("cuenta/{cuentaId}")
    public ResponseEntity getByCuentaId(@PathVariable("cuentaId") int cuentaId){
        logger.info("Recibida la solicitud GET de busqueda de un registro mediante la id de cuenta {cuentaId} para /api/movimientos");

        try {
            return new ResponseEntity<>(movimientoService.getAllByCuentaId(cuentaId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovimientoDTO save(@RequestBody MovimientoDTO movimientoDTO){
        logger.info("Recibida la solicitud POST para la creacion de datos en /api/movimientos");

        return movimientoService.save(movimientoDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity update(@RequestBody MovimientoDTO movimientoDTO){
        try {
            logger.info("Recibida la solicitud PUT para la actualizacion de datos en /api/movimientos");

            return new ResponseEntity<>(movimientoService.update(movimientoDTO), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Excepcion al procesar la peticion PUT en /api/movimientos...", e);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        try {
            logger.info("Recibida la solicitud DELETE para la eliminacion de datos en /api/movimientos");

            return new ResponseEntity<>(movimientoService.delete(id), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Excepción al procesar la peticion DELETE en /api/movimientos.", e);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
