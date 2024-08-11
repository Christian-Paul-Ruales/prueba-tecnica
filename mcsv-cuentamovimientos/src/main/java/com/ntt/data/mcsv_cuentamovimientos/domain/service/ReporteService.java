package com.ntt.data.mcsv_cuentamovimientos.domain.service;

import com.ntt.data.mcsv_cuentamovimientos.client.ClienteClient;
import com.ntt.data.mcsv_cuentamovimientos.client.dto.ClienteDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.EstadoCuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.MovimientoDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.util.ServiceUtil;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReporteService {
    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private MovimientoService movimientoService;
    @Autowired
    private CuentaService cuentaService;
    @Autowired
    private ClienteClient clienteClient;

    public List<EstadoCuentaDTO> generarReporteGeneral(String fechaInicio, String fechaFin){
        Date fechaInicial = serviceUtil.convertiStringAFecha(fechaInicio, DominioConstantes.PTR_FECHA_PATH);
        Date fechaFinal = serviceUtil.convertiStringAFecha(fechaFin, DominioConstantes.PTR_FECHA_PATH);

        return generarReporteGeneral(fechaInicial, fechaFinal);
    }

    public List<EstadoCuentaDTO> generarReporteGeneral(Date fechaInicio, Date fechaFin) {

        List<ClienteDTO> lstClientes = clienteClient.getAll();
        List<EstadoCuentaDTO> lstEstadoCuenta = new ArrayList<>();
        for (ClienteDTO clienteDTO: lstClientes){
            lstEstadoCuenta.addAll(generarReporteCliente(clienteDTO.getId(), fechaInicio, fechaFin));
        }
        return lstEstadoCuenta;
    }
    public List<EstadoCuentaDTO> generarReporteCliente(int clienteId, String fechaInicio, String fechaFin){
        Date fechaInicial = serviceUtil.convertiStringAFecha(fechaInicio, DominioConstantes.PTR_FECHA_PATH);
        Date fechaFinal = serviceUtil.convertiStringAFecha(fechaFin, DominioConstantes.PTR_FECHA_PATH);

        return generarReporteCliente(clienteId, fechaInicial, fechaFinal);
    }

    public List<EstadoCuentaDTO> generarReporteCliente(int clienteId, Date fechaInicio, Date fechaFin){
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
            estadoCuentaDTO = new EstadoCuentaDTO(clienteDTO.getNombre(),cuentaDTO.getNumeroCuenta(),cuentaDTO.getTipoCuenta(),cuentaDTO.getEstado(),cuentaDTO.getSaldoInicial(), saldoActual, lstMovimientosCuenta);
            lstEstadoCuenta.add(estadoCuentaDTO);
        }

        return lstEstadoCuenta;
    }
}
