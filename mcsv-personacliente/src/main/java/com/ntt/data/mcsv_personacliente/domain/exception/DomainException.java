package com.ntt.data.mcsv_personacliente.domain.exception;

//@ResponseStatus(HttpStatus.CONFLICT)
public class DomainException extends RuntimeException{
    public DomainException(String msg){
        super(msg);
    }
}
