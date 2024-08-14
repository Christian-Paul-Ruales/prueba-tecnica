package com.ntt.data.mcsv_personacliente.web.handler.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseBean {
    public long timestamp;
    public List<ErrorBean> errors;
}
