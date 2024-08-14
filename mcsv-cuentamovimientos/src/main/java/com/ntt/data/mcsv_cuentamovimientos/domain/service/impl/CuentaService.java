package com.ntt.data.mcsv_cuentamovimientos.domain.service.impl;

import com.ntt.data.mcsv_cuentamovimientos.client.ClienteClient;
import com.ntt.data.mcsv_cuentamovimientos.client.dto.ClienteDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.ICuentaService;
import com.ntt.data.mcsv_cuentamovimientos.domain.util.CuentaUtil;
import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.ICuentaRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CuentaService implements ICuentaService {
    @Autowired
    private  ICuentaRepository cuentaRepository;

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private CuentaUtil cuentaUtil;


    @Override
    public List<CuentaDTO> getAll(){
        return cuentaRepository.getAll();
    }

    @Override
    public CuentaDTO getById(int id){
        CuentaDTO cuentaDTO = cuentaRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_CUENTA_NO_ENCONTRADO, id))
        );
        /**
         * Consumo de datos del cliente que se encuentra en el otro microservicio
         * */
        ClienteDTO clienteDTO = clienteClient.getById(cuentaDTO.getClienteId());
        log.info(String.format("Se realizó la consulta de información  del microservicio cliente %s desde el metodo getById", cuentaDTO.getClienteId()));
        cuentaDTO.setClienteNombre(clienteDTO.getNombre());

        return cuentaDTO;
    }

    @Override
    public CuentaDTO save(CuentaDTO cuentaDTO){
        String numeroCuenta = cuentaUtil.generarCuenta(DominioConstantes.TAMANO_CUENTA);
        cuentaDTO.setNumeroCuenta(numeroCuenta);
        cuentaDTO.setSaldoActual(cuentaDTO.getSaldoInicial());
        CuentaDTO cuentaGuardadaDTO = cuentaRepository.save(cuentaDTO);

        // obtener el nombre del cliente
        ClienteDTO clienteDTO = clienteClient.getById(cuentaGuardadaDTO.getClienteId());
        log.info(String.format("Se realizó la consulta de información  del microservicio cliente %s desde el metodo save", cuentaDTO.getClienteId()));

        cuentaGuardadaDTO.setClienteNombre(clienteDTO.getNombre());
        return cuentaGuardadaDTO;

    }

    @Override
    public CuentaDTO update(CuentaDTO cuentaDTO){
        return cuentaRepository.update(cuentaDTO);
    }

    @Override
    public CuentaDTO delete(int id){
        CuentaDTO cuentaDTO = getById(id);
        cuentaRepository.delete(id);
        return cuentaDTO;
    }

    @Override
    public List<CuentaDTO> getByClienteId(int id){
        return cuentaRepository.getByClienteId(id);
    }
}
