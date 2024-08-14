package com.ntt.data.api_gateway.exception;

import com.ntt.data.api_gateway.bean.ResponseBean;
import com.ntt.data.api_gateway.bean.ErrorBean;
import jakarta.ws.rs.NotFoundException;
import org.apache.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Date;

@RestControllerAdvice
public class CommonExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(ParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseBean> handleParseException(ParseException ex) {
        logger.info("Excepcion ParseException api gateway procesada...");
        ResponseBean res = new ResponseBean();
        res.setTimestamp(new Date().getTime());
        res.setErrors(new ArrayList<>());
        res.getErrors().add(new ErrorBean("E0001",ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseBean> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.info("Excepcion MethodArgumentNotValidException api gateway procesada...");
        ResponseBean res = new ResponseBean();
        res.setTimestamp(new Date().getTime());
        res.setErrors(new ArrayList<>());
        res.getErrors().add(new ErrorBean("E0002",ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseBean> handleNotFoundException(MethodArgumentNotValidException ex) {
        logger.info("Excepcion NotFoundException api gateway procesada...");

        ResponseBean res = new ResponseBean();
        res.setTimestamp(new Date().getTime());
        res.setErrors(new ArrayList<>());
        res.getErrors().add(new ErrorBean("E0003",ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
