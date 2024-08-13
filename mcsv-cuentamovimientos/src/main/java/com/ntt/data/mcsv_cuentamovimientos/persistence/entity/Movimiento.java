package com.ntt.data.mcsv_cuentamovimientos.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;

    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    private Double valor;

    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "cuentaId", referencedColumnName = "id")
    private Cuenta cuentaId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Cuenta cuentaId) {
        this.cuentaId = cuentaId;
    }
}
