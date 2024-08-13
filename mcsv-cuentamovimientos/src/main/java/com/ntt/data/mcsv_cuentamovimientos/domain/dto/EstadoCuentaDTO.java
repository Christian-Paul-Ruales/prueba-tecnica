package com.ntt.data.mcsv_cuentamovimientos.domain.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCuentaDTO {
    /**
     * Nombre del cliente
     * */
    private String nombre;

    private String numeroCuenta;

    private String tipoCuenta;

    private Double saldoInicial;

    private Boolean estado;

    private Double saldoDisponible;

    private List<MovimientoDTO> lstMovimientos;


}
