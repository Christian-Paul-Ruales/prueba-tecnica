package com.ntt.data.api_gateway.handler.exception;


import com.ntt.data.api_gateway.handler.bean.ErrorBean;
import com.ntt.data.api_gateway.handler.bean.ResponseBean;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Date;
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseBean> handleNotFoundException(NotFoundException ex) {
        log.info("Excepcion NotFoundException iniciada en handlerexception...");

        ResponseBean res = new ResponseBean();
        res.setTimestamp(new Date().getTime());
        res.setErrors(new ArrayList<>());
        res.getErrors().add(new ErrorBean("E0003",ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }



    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseBean> handleIlegalException(RestClientException ex) {
        log.info("Excepcion RestClientException iniciada en handlerexception...");

        ResponseBean res = new ResponseBean();
        res.setTimestamp(new Date().getTime());
        res.setErrors(new ArrayList<>());
        res.getErrors().add(new ErrorBean("E0004",ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseBean> handleGenericException(Exception ex) {
        log.info("Excepcion Exception iniciada en handlerexception...");

        ResponseBean res = new ResponseBean();
        res.setTimestamp(new Date().getTime());
        res.setErrors(new ArrayList<>());
        res.getErrors().add(new ErrorBean("E0005",ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
