package com.ntt.data.mcsv_cuentamovimientos.domain.service;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.EstadoCuentaDTO;

import java.util.Date;
import java.util.List;

public interface IReporteService {
    List<EstadoCuentaDTO> generarReporteGeneral(String fechaInicio, String fechaFin);

    List<EstadoCuentaDTO> generarReporteGeneral(Date fechaInicio, Date fechaFin);

    List<EstadoCuentaDTO> generarReporteCliente(int clienteId, String fechaInicio, String fechaFin);

    List<EstadoCuentaDTO> generarReporteCliente(int clienteId, Date fechaInicio, Date fechaFin);
}
