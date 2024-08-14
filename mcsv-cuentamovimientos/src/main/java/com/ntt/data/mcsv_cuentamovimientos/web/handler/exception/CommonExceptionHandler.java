package com.ntt.data.mcsv_cuentamovimientos.web.handler.exception;

import com.ntt.data.mcsv_cuentamovimientos.web.handler.bean.ErrorBean;
import com.ntt.data.mcsv_cuentamovimientos.web.handler.bean.ResponseBean;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.ParseException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(ParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseBean> handleParseException(ParseException ex) {
        log.info("Excepcion ParseException iniciada en handlerexception...");

        ResponseBean res = new ResponseBean();
        res.setTimestamp(new Date().getTime());
        res.setErrors(new ArrayList<>());
        res.getErrors().add(new ErrorBean("E0001",ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseBean> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.info("Excepcion handleMethodArgumentNotValidException iniciada en handlerexception...");

        ResponseBean res = new ResponseBean();
        res.setTimestamp(new Date().getTime());
        res.setErrors(new ArrayList<>());
        res.getErrors().add(new ErrorBean("E0002",ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

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

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseBean> handleServiceException(ServiceException ex) {
        log.info("Excepcion ServiceException iniciada en handlerexception...");

        ResponseBean res = new ResponseBean();
        res.setTimestamp(new Date().getTime());
        res.setErrors(new ArrayList<>());
        res.getErrors().add(new ErrorBean("E0004",ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseBean> handleIlegalException(IllegalStateException ex) {
        log.info("Excepcion IllegalStateException iniciada en handlerexception...");

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
