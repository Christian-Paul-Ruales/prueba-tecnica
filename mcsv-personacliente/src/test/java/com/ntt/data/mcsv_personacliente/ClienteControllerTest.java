package com.ntt.data.mcsv_personacliente;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.domain.exception.DomainException;
import com.ntt.data.mcsv_personacliente.domain.service.ClienteService;
import com.ntt.data.mcsv_personacliente.web.controller.ClienteController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteControllerTest {
    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void init(){

        MockitoAnnotations.openMocks(this);


    }

    @Test
    public void getAllTest(){
        List<ClienteDTO> data = new ArrayList<>();
        data.add(getClienteDTO());

        when(clienteController.getAll()).thenReturn(data);

        List<ClienteDTO> response = clienteController.getAll();
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(response.size(), 1);
    }




    @Test
    public void getById(){
        when(clienteService.getById(getClienteDTO().getId())).thenReturn(getClienteDTO());
        ResponseEntity<ClienteDTO> response = clienteController.getById(getClienteDTO().getId());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getByIdNotFound(){
        when(clienteService.getById(10)).thenThrow(new DomainException("error"));
        ResponseEntity<ClienteDTO> response = clienteController.getById(10);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);


    }

    @Test
    public void save(){
        ClienteDTO c = getClienteDTO();
        when(clienteService.save(c)).thenReturn(c);
        ClienteDTO response = clienteController.save(c);
        assertNotNull(c);
        assertEquals(response, c);
    }

    @Test
    public void update(){
        when(clienteService.update(getClienteDTO())).thenReturn(getClienteDTO());
        ResponseEntity<ClienteDTO> response = clienteController.update(getClienteDTO());
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);

    }

    @Test
    public void updateNotFound(){
        ClienteDTO nuevaCuenta = getClienteDTO();
        nuevaCuenta.setId(null);
        when(clienteService.update(nuevaCuenta)).thenThrow(new DomainException("ERROR DATO NO REGISTRADO"));
        ResponseEntity<ClienteDTO> response = clienteController.update(nuevaCuenta);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);

    }

    @Test
    public void delete(){
        when(clienteService.delete(getClienteDTO().getId())).thenReturn(getClienteDTO());
        ResponseEntity<ClienteDTO> response = clienteController.delete(getClienteDTO().getId());
        assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void deleteNotFound(){
        ClienteDTO nuevaCuenta = getClienteDTO();
        nuevaCuenta.setId(null);
        when(clienteService.delete(10)).thenThrow(new DomainException("ERROR DATO NO REGISTRADO"));
        ResponseEntity<ClienteDTO> response = clienteController.delete(10);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);

    }


    public ClienteDTO getClienteDTO(){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(1);
        clienteDTO.setContrasena("sdasda");
        clienteDTO.setEstado(true);
        clienteDTO.setGenero("M");
        clienteDTO.setEdad(12);
        clienteDTO.setDireccion("la mena 2");
        clienteDTO.setNombre("Christian Ruales");
        clienteDTO.setIdentificacion("1123115411");
        clienteDTO.setPersonaId("asda111");
        clienteDTO.setTelefono("09938119231");

        return clienteDTO;
    }
}
