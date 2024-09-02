package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerException burgerException) {
        BurgerErrorResponse errorResponse
                = new BurgerErrorResponse(burgerException.getMessage());
        return new ResponseEntity<>(errorResponse, burgerException.getHttpStatus());
    }
}