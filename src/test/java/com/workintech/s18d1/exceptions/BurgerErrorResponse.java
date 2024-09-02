package com.workintech.s18d1.exceptions;

import lombok.Getter;

@Getter
public class BurgerErrorResponse {
    private String message;

    public BurgerErrorResponse(String message) {
        this.message = message;
    }
}
