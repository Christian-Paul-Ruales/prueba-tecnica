package com.ntt.data.mcsv_cuentamovimientos.domain.dto;


import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@NoArgsConstructor
public class MovimientoDTO {
    private Integer id;
    @NotNull
    @FutureOrPresent
    private Date fecha;

    @NotNull
    @NotBlank
    private String tipoMovimiento;

    @NotNull
    private Double valor;

    @NotNull
    private Double saldo;

    @NotNull
    @Positive(message = "El valor de cuenta debe ser mayor a cero(0)")
    private Integer cuentaId;

    private String numeroCuenta;


    private String tipoCuenta;


}
