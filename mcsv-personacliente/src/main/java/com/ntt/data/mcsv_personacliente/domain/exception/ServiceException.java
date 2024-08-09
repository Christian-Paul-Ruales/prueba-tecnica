package com.ntt.data.mcsv_personacliente.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.CONFLICT)
public class ServiceException extends RuntimeException{
    public ServiceException(String msg){
        super(msg);
    }
}
