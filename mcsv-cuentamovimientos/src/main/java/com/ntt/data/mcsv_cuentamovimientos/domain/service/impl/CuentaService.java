package com.ntt.data.mcsv_cuentamovimientos.domain.service.impl;

import com.ntt.data.mcsv_cuentamovimientos.client.ClienteClient;
import com.ntt.data.mcsv_cuentamovimientos.client.dto.ClienteDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.ICuentaService;
import com.ntt.data.mcsv_cuentamovimientos.domain.util.CuentaUtil;
import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.ICuentaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CuentaService implements ICuentaService {

    private final ICuentaRepository cuentaRepository;

    private final CuentaUtil cuentaUtil;


    @Override
    public List<CuentaDTO> getAll(){

        return cuentaRepository.getAll().stream().map(
                cuentaDTO -> {
                    cuentaDTO = cuentaUtil.procesarBusquedaCliente(cuentaDTO);
                    return cuentaDTO;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public CuentaDTO getById(int id){
        CuentaDTO cuentaDTO = cuentaRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_CUENTA_NO_ENCONTRADO, id))
        );

        return cuentaUtil.procesarBusquedaCliente(cuentaDTO);
    }

    @Override
    public CuentaDTO save(CuentaDTO cuentaDTO){
        String numeroCuenta = cuentaUtil.generarCuenta(DominioConstantes.TAMANO_CUENTA);
        cuentaDTO.setNumeroCuenta(numeroCuenta);
        cuentaDTO.setSaldoActual(cuentaDTO.getSaldoInicial());

        CuentaDTO cuentaDTOguardada = cuentaRepository.save(cuentaDTO);


        return cuentaUtil.procesarBusquedaCliente(cuentaDTOguardada);

    }

    @Override
    public CuentaDTO update(CuentaDTO cuentaDTO){
        cuentaDTO =cuentaRepository.update(cuentaDTO);
        return cuentaUtil.procesarBusquedaCliente(cuentaDTO);

    }

    @Override
    public CuentaDTO delete(int id){
        CuentaDTO cuentaDTO = getById(id);
        cuentaRepository.delete(id);
        return cuentaDTO;
    }

    @Override
    public List<CuentaDTO> getByClienteId(int id){
        return  cuentaRepository.getByClienteId(id).stream().map(
                cuentaDTO -> {
                    cuentaDTO = cuentaUtil.procesarBusquedaCliente(cuentaDTO);
                    return cuentaDTO;
                }
        ).collect(Collectors.toList());
    }
}
