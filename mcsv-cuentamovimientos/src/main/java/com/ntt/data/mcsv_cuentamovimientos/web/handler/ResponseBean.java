package com.ntt.data.mcsv_cuentamovimientos.web.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseBean {
    public long timestamp;
    public List<ErrorBean> errors;
}
