package com.ntt.data.api_gateway.handler.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseBean {
    public long timestamp;
    public List<ErrorBean> errors;
}
