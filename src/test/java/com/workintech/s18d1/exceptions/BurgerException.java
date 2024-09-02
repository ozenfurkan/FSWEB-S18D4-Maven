package com.workintech.s18d1.exceptions;
import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public class BurgerException extends RuntimeException{
    private HttpStatus HttpStatus;

    public BurgerException(String message, HttpStatus HttpStatus) {
        super(message);
        this.HttpStatus = HttpStatus;
    }

}
