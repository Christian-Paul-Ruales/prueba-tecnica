package com.ntt.data.mcsv_cuentamovimientos.domain.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@NoArgsConstructor
public class MovimientoDTO {
    private Integer id;

    private Date fecha;

    private String tipoMovimiento;

    private Double valor;

    private Double saldo;

    private Integer cuentaId;

    private String numeroCuenta;

    private String tipoCuenta;


}
