package com.ntt.data.mcsv_cuentamovimientos.web.controller;

import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.EstadoCuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;

    @GetMapping("/fecha/{fechaInicio}/{fechaFin}")
    public List<EstadoCuentaDTO> getReporteEstadoCuenta(@PathVariable("fechaInicio") String fechaInicio,@PathVariable("fechaFin") String fechaFin ){

        return reporteService.generarReporteGeneral(fechaInicio, fechaFin);

    }
}
