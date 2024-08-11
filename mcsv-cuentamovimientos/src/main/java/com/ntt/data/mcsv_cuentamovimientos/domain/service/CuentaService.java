package com.ntt.data.mcsv_cuentamovimientos.domain.service;

import com.ntt.data.mcsv_cuentamovimientos.client.ClienteClient;
import com.ntt.data.mcsv_cuentamovimientos.client.dto.ClienteDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.util.CuentaUtil;
import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.ICuentaRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private ICuentaRepository cuentaRepository;

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private CuentaUtil cuentaUtil;

    public List<CuentaDTO> getAll(){
        return cuentaRepository.getAll();
    }

    public CuentaDTO getById(int id){
        CuentaDTO cuentaDTO = cuentaRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_CUENTA_NO_ENCONTRADO, id))
        );
        ClienteDTO clienteDTO = clienteClient.getById(cuentaDTO.getClienteId());

        cuentaDTO.setClienteNombre(clienteDTO.getNombre());

        return cuentaDTO;
    }

    public CuentaDTO save(CuentaDTO cuentaDTO){
        String numeroCuenta = cuentaUtil.generarCuenta(DominioConstantes.TAMANO_CUENTA);
        cuentaDTO.setNumeroCuenta(numeroCuenta);
        cuentaDTO.setSaldoActual(cuentaDTO.getSaldoInicial());
        CuentaDTO cuentaGuardadaDTO = cuentaRepository.save(cuentaDTO);

        // obtener el nombre del cliente
        ClienteDTO clienteDTO = clienteClient.getById(cuentaGuardadaDTO.getClienteId());
        cuentaGuardadaDTO.setClienteNombre(clienteDTO.getNombre());
        return cuentaGuardadaDTO;

    }

    public CuentaDTO update(CuentaDTO cuentaDTO){
        getById(cuentaDTO.getId());
        return cuentaRepository.update(cuentaDTO);
    }                                                                                   

    public CuentaDTO delete(int id){
        CuentaDTO cuentaDTO = getById(id);
        cuentaRepository.delete(id);
        return cuentaDTO;
    }

    public List<CuentaDTO> getByClienteId(int id){
        return cuentaRepository.getByClienteId(id);
    }
}
