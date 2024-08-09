package com.ntt.data.mcsv_cuentamovimientos.persistence.mapper;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CuentaMapper {

    CuentaMapper INSTANCE = Mappers.getMapper(CuentaMapper.class);

    Cuenta getEntidad(CuentaDTO cuentaDTO);

    List<Cuenta> getEntidades(List<CuentaDTO> lstCuentaDTO);

    @InheritInverseConfiguration

    @Mapping(target="lstMovimientos", ignore = true)
    CuentaDTO getDTO(Cuenta cuenta);

    List<CuentaDTO> getDTOs(List<Cuenta> lstCuenta);

}
