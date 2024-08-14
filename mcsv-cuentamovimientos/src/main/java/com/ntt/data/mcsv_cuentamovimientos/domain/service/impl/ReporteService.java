package com.ntt.data.mcsv_cuentamovimientos.domain.service.impl;

import com.ntt.data.mcsv_cuentamovimientos.client.ClienteClient;
import com.ntt.data.mcsv_cuentamovimientos.client.dto.ClienteDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.EstadoCuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.IReporteService;
import com.ntt.data.mcsv_cuentamovimientos.domain.util.ServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReporteService implements IReporteService {

    private final ServiceUtil serviceUtil;
    private final MovimientoService movimientoService;
    private final CuentaService cuentaService;
    private final ClienteClient clienteClient;


    @Override
    public List<EstadoCuentaDTO> generarReporteGeneral(String fechaInicio, String fechaFin){
        log.info("Generar reporte con fechas sin parsear");

        Date fechaInicial = serviceUtil.convertiStringAFecha(fechaInicio, DominioConstantes.PTR_FECHA_PATH);
        Date fechaFinal = serviceUtil.convertiStringAFecha(fechaFin, DominioConstantes.PTR_FECHA_PATH);
        return generarReporteGeneral(fechaInicial, fechaFinal);
    }

    @Override
    public List<EstadoCuentaDTO> generarReporteGeneral(Date fechaInicio, Date fechaFin) {
        log.info("Generar reporte con fechas sin convertidas a tipo Date");

        List<ClienteDTO> lstClientes = clienteClient.getAll();
        List<EstadoCuentaDTO> lstEstadoCuenta = new ArrayList<>();
        for (ClienteDTO clienteDTO: lstClientes){
            lstEstadoCuenta.addAll(generarReporteCliente(clienteDTO.getId(), fechaInicio, fechaFin));
        }
        return lstEstadoCuenta;
    }
    @Override
    public List<EstadoCuentaDTO> generarReporteCliente(int clienteId, String fechaInicio, String fechaFin){
        Date fechaInicial = serviceUtil.convertiStringAFecha(fechaInicio, DominioConstantes.PTR_FECHA_PATH);
        Date fechaFinal = serviceUtil.convertiStringAFecha(fechaFin, DominioConstantes.PTR_FECHA_PATH);

        return generarReporteCliente(clienteId, fechaInicial, fechaFinal);
    }

    @Override
    public List<EstadoCuentaDTO> generarReporteCliente(int clienteId, Date fechaInicio, Date fechaFin){
        log.info("Generar reporte por cliente");

        List<CuentaDTO> lstCuentas= cuentaService.getByClienteId(clienteId);
        List<MovimientoDTO> lstMovimientosCuenta;
        List<EstadoCuentaDTO> lstEstadoCuenta = new ArrayList<>();

        Double saldoActual;
        EstadoCuentaDTO estadoCuentaDTO;
        ClienteDTO clienteDTO;

        for(CuentaDTO cuentaDTO: lstCuentas){
            lstMovimientosCuenta = movimientoService.getAllByCuentaId(cuentaDTO.getClienteId());
            saldoActual = lstMovimientosCuenta.isEmpty() ? cuentaDTO.getSaldoInicial() : lstMovimientosCuenta.get(lstMovimientosCuenta.size() - 1).getSaldo();

            clienteDTO = clienteClient.getById(cuentaDTO.getClienteId());
            estadoCuentaDTO = new EstadoCuentaDTO(clienteDTO.getNombre(),cuentaDTO.getNumeroCuenta(),cuentaDTO.getTipoCuenta(),cuentaDTO.getSaldoInicial(), cuentaDTO.getEstado(), saldoActual, lstMovimientosCuenta);
            lstEstadoCuenta.add(estadoCuentaDTO);
        }
        log.info("Generar reporte por cliente - Metodo finalizado");

        return lstEstadoCuenta;
    }
}
