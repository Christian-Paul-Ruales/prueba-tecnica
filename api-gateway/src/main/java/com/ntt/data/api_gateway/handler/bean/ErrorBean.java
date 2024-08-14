package com.ntt.data.api_gateway.handler.bean;

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
