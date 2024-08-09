package com.ntt.data.mcsv_cuentamovimientos.domain.dto;

import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;

import java.util.List;

public class CuentaDTO {
    private Integer id;

    private String numeroCuenta;

    private String tipoCuenta;

    private Double saldoInicial;

    private Boolean estado;

    private List<Movimiento> lstMovimientos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Movimiento> getLstMovimientos() {
        return lstMovimientos;
    }

    public void setLstMovimientos(List<Movimiento> lstMovimientos) {
        this.lstMovimientos = lstMovimientos;
    }
}
