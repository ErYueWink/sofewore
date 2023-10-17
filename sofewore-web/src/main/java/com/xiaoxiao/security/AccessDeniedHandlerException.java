package com.xiaoxiao.security;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class AccessDeniedHandlerException {


    @ExceptionHandler(AccessDeniedException.class)
    public void defaultExceptionHandler(AccessDeniedException e){
        e.printStackTrace();
    }

}
