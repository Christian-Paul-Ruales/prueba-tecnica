package com.ntt.data.mcsv_cuentamovimientos.domain.dto;

import java.util.List;

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

    public EstadoCuentaDTO(String nombre, String numeroCuenta, String tipoCuenta, Boolean estado, Double saldoInicial, Double saldoDisponible, List<MovimientoDTO> lstMovimientos) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.estado = estado;
        this.saldoInicial = saldoInicial;
        this.saldoDisponible = saldoDisponible;
        this.lstMovimientos = lstMovimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<MovimientoDTO> getLstMovimientos() {
        return lstMovimientos;
    }

    public void setLstMovimientos(List<MovimientoDTO> lstMovimientos) {
        this.lstMovimientos = lstMovimientos;
    }
}
