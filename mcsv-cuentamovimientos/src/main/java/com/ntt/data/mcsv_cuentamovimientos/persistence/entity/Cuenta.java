package com.ntt.data.mcsv_cuentamovimientos.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cliente_id")
    private Integer clienteId;
    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "saldo_inicial")
    private Double saldoInicial;

    @Column(name = "saldo_actual")
    private Double saldoActual;

    private Boolean estado;

    @OneToMany(mappedBy = "cuentaId",cascade = CascadeType.ALL)
    private List<Movimiento> lstMovimientos;


}
