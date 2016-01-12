package com.atme8.activity.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;import java.lang.IllegalArgumentException;

/**
 * Created by Administrator on 2015/12/29.
 */
@ControllerAdvice
public class GlobalControolerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public void illegalArgExc(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
