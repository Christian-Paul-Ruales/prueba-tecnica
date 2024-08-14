package com.ntt.data.mcsv_cuentamovimientos.persistence.mapper;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {


    @Mappings({
            @Mapping(target="cuentaId.id", source = "cuentaId"),
            @Mapping(target="cuentaId.numeroCuenta", source = "numeroCuenta"),
            @Mapping(target="cuentaId.tipoCuenta", source = "tipoCuenta"),
    })
    Movimiento getEntidad(MovimientoDTO movimientoDTO);

    List<Movimiento> getEntidades(List<MovimientoDTO> lstMovimientoDTO);

    @InheritInverseConfiguration
    MovimientoDTO getDTO(Movimiento movimiento);
    List<MovimientoDTO> getDTOs(List<Movimiento> lstMovimiento);

}
