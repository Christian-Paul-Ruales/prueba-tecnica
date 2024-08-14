package com.ntt.data.mcsv_personacliente.web.handler.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorBean {
    public String  errorCode;
    public String  errorMessage;
}
