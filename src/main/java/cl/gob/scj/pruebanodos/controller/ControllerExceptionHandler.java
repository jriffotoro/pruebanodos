package cl.gob.scj.pruebanodos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.gob.scj.pruebanodos.dto.RespuestaJSON;


@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class); 

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaJSON> excepSQL(HttpServletRequest request, Exception e) {	
        LOGGER.debug("[ERROR]: {}", e); 
        return new ResponseEntity<>(new RespuestaJSON(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}