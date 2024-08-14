package com.ntt.data.mcsv_cuentamovimientos.domain.dto;

import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class CuentaDTO {
    private Integer id;
    @NotNull
    private Integer clienteId;

    private String clienteNombre;
    /**
     * SE GENERA AUTOMATICAMENTE
     * */
    private String numeroCuenta;
    @NotNull(message = "Tipo de cuenta no puede ser nulo, datos permitidos, AHORROS, CORRIENTE ")
    @NotBlank
    private String tipoCuenta;
    @NotNull
    @PositiveOrZero(message = "El saldo inicial no puede ser negativo")
    private Double saldoInicial;

    /***
     * Se autollena con datos y calculos de saldo inicial y Movimiento.saldo
     * */
    private Double saldoActual;

    private Boolean estado;

    private List<Movimiento> lstMovimientos;



}
