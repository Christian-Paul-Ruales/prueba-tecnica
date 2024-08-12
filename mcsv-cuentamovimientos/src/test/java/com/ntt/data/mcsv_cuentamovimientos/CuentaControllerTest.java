package com.ntt.data.mcsv_cuentamovimientos;



import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.CuentaService;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import com.ntt.data.mcsv_cuentamovimientos.web.controller.CuentaController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CuentaControllerTest {
    @Mock
    private CuentaService cuentaService;

    @InjectMocks
    private CuentaController cuentaController;

    @BeforeEach
    public void init(){

        MockitoAnnotations.openMocks(this);


    }

    @Test
    public void getAllTest(){
        List<CuentaDTO> data = new ArrayList<>();
        data.add(getCuentaDTO());

        when(cuentaController.getAll()).thenReturn(data);

        List<CuentaDTO> response = cuentaController.getAll();
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(response.size(), 1);
    }




    @Test
    public void getById(){
        when(cuentaService.getById(getCuentaDTO().getId())).thenReturn(getCuentaDTO());
        ResponseEntity<CuentaDTO> response = cuentaController.getById(getCuentaDTO().getId());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getByIdNotFound(){
        when(cuentaService.getById(10)).thenThrow(new DomainException("error"));
        ResponseEntity<CuentaDTO> response = cuentaController.getById(10);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);


    }

    @Test
    public void save(){
        CuentaDTO c = getCuentaDTO();
        when(cuentaService.save(c)).thenReturn(c);
        CuentaDTO response = cuentaController.save(c);
        assertNotNull(c);
        assertEquals(response, c);
    }

    @Test
    public void update(){
        when(cuentaService.update(getCuentaDTO())).thenReturn(getCuentaDTO());
        ResponseEntity<CuentaDTO> response = cuentaController.update(getCuentaDTO());
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);

    }

    @Test
    public void updateNotFound(){
        CuentaDTO nuevaCuenta = getCuentaDTO();
        nuevaCuenta.setId(null);
        when(cuentaService.update(nuevaCuenta)).thenThrow(new DomainException("ERROR DATO NO REGISTRADO"));
        ResponseEntity<CuentaDTO> response = cuentaController.update(nuevaCuenta);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);

    }

    @Test
    public void delete(){
        when(cuentaService.delete(getCuentaDTO().getId())).thenReturn(getCuentaDTO());
        ResponseEntity<CuentaDTO> response = cuentaController.delete(getCuentaDTO().getId());
        assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void deleteNotFound(){
        CuentaDTO nuevaCuenta = getCuentaDTO();
        nuevaCuenta.setId(null);
        when(cuentaService.delete(10)).thenThrow(new DomainException("ERROR DATO NO REGISTRADO"));
        ResponseEntity<CuentaDTO> response = cuentaController.delete(10);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);

    }


    public CuentaDTO getCuentaDTO(){
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(1);
        cuentaDTO.setClienteId(1);
        cuentaDTO.setId(1);
        cuentaDTO.setNumeroCuenta("12345678");
        cuentaDTO.setTipoCuenta("CORRIENTE");
        cuentaDTO.setSaldoInicial(1231.12);
        cuentaDTO.setSaldoActual(1231.12);
        cuentaDTO.setEstado(true);
        return cuentaDTO;
    }

}
