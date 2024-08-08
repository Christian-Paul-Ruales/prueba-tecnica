package com.ntt.data.mcsv_personacliente.persistence.mapper;

import com.ntt.data.mcsv_personacliente.domain.dto.ClienteDTO;
import com.ntt.data.mcsv_personacliente.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente getEntidad(ClienteDTO clienteDTO);

    List<Cliente> getEntidades(List<ClienteDTO> clientesDTO);

    @InheritInverseConfiguration
    ClienteDTO getDTO(Cliente cliente);

    List<ClienteDTO> getDTOs(List<Cliente> clientes);
}
