package com.ntt.data.mcsv_cuentamovimientos.domain.service.impl;

import com.ntt.data.mcsv_cuentamovimientos.client.ClienteClient;
import com.ntt.data.mcsv_cuentamovimientos.client.dto.ClienteDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.service.ICuentaService;
import com.ntt.data.mcsv_cuentamovimientos.domain.util.CuentaUtil;
import com.ntt.data.mcsv_cuentamovimientos.domain.constantes.DominioConstantes;
import com.ntt.data.mcsv_cuentamovimientos.domain.dto.CuentaDTO;
import com.ntt.data.mcsv_cuentamovimientos.domain.exception.DomainException;
import com.ntt.data.mcsv_cuentamovimientos.domain.repository.ICuentaRepository;
import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Cuenta;
import com.ntt.data.mcsv_cuentamovimientos.persistence.mapper.CuentaMapper;
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
    private final CuentaMapper cuentaMapper;

    @Override
    public List<CuentaDTO> getAll(){

        return cuentaMapper.getDTOs(cuentaRepository.getAll()).stream().map(
                cuentaDTO -> {
                    cuentaDTO = cuentaUtil.procesarBusquedaCliente(cuentaDTO);
                    return cuentaDTO;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public CuentaDTO getById(int id){
        Cuenta cuenta = cuentaRepository.getById(id).orElseThrow(
                () -> new DomainException(String.format(DominioConstantes.MSG_CUENTA_NO_ENCONTRADO, id))
        );

        return cuentaUtil.procesarBusquedaCliente(cuentaMapper.getDTO(cuenta));
    }

    @Override
    public CuentaDTO save(CuentaDTO cuentaDTO){
        String numeroCuenta = cuentaUtil.generarCuenta(DominioConstantes.TAMANO_CUENTA);
        cuentaDTO.setNumeroCuenta(numeroCuenta);
        cuentaDTO.setSaldoActual(cuentaDTO.getSaldoInicial());

        Cuenta cuenta = cuentaMapper.getEntidad(cuentaDTO);
        CuentaDTO cuentaDTOguardada = cuentaMapper.getDTO(cuentaRepository.save(cuenta));

        return cuentaUtil.procesarBusquedaCliente(cuentaDTOguardada);

    }

    @Override
    public CuentaDTO update(CuentaDTO cuentaDTO){
        Cuenta cuenta = cuentaMapper.getEntidad(cuentaDTO);
        cuentaDTO =cuentaMapper.getDTO(cuentaRepository.update(cuenta));

        return cuentaUtil.procesarBusquedaCliente(cuentaDTO);

    }

    @Override
    public void delete(int id){
        cuentaRepository.delete(id);
    }

    @Override
    public List<CuentaDTO> getByClienteId(int id){
        return  cuentaRepository.getByClienteId(id).stream().map(
                cuenta ->  cuentaUtil.procesarBusquedaCliente(cuentaMapper.getDTO(cuenta))
        ).collect(Collectors.toList());
    }
}
