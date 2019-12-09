package com.sergei.fruitshopapi.controllers;

import com.sergei.fruitshopapi.servises.ResponseNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResponseNotFoundException.class)
    private ResponseEntity<Object> hendleNotFaundException(Exception exception, WebRequest webRequest){
        return new ResponseEntity<>(
                "Resource not found",
                new HttpHeaders(),
                HttpStatus.NOT_FOUND
        );
    }

}
