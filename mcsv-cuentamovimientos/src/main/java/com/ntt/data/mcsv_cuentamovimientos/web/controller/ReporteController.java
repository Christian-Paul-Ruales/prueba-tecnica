package com.ntt.data.mcsv_cuentamovimientos.web.controller;

import com.ntt.data.mcsv_cuentamovimientos.domain.dto.EstadoCuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.IReporteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final IReporteService reporteService;


    @GetMapping("/fecha/{fechaInicio}/{fechaFin}")
    public List<EstadoCuentaDTO> getReporteEstadoCuenta(@PathVariable("fechaInicio") String fechaInicio,@PathVariable("fechaFin") String fechaFin ){
        log.info("Recibida la solicitud GET para reporte /fecha/{fechaInicio}/{fechaFin}");

        return reporteService.generarReporteGeneral(fechaInicio, fechaFin);

    }
}
