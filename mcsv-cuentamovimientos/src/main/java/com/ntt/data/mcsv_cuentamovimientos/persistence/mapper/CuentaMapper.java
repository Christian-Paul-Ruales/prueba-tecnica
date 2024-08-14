package com.ntt.data.mcsv_cuentamovimientos.persistence.mapper;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import org.aspectj.lang.annotation.After;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {


    Cuenta getEntidad(CuentaDTO cuentaDTO);
    List<Cuenta> getEntidades(List<CuentaDTO> lstCuentaDTO);

    @InheritInverseConfiguration

    @Mapping(target="lstMovimientos", ignore = true)

    CuentaDTO getDTO(Cuenta cuenta);
    List<CuentaDTO> getDTOs(List<Cuenta> lstCuenta);


}
