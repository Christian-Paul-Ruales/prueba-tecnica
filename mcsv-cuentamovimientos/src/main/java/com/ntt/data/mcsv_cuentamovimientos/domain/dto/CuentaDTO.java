package com.ntt.data.mcsv_cuentamovimientos.domain.dto;

import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;
import lombok.Data;

import java.util.List;

@Data
public class CuentaDTO {
    private Integer id;

    private Integer clienteId;

    private String clienteNombre;

    private String numeroCuenta;

    private String tipoCuenta;

    private Double saldoInicial;

    private Double saldoActual;

    private Boolean estado;

    private List<Movimiento> lstMovimientos;



}
