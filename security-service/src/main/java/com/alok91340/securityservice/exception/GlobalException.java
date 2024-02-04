package com.alok91340.securityservice.exception;

import org.springframework.http.HttpStatus;

public class GlobalException extends RuntimeException {

    private String message;
    private HttpStatus status;

    public GlobalException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public GlobalException(String message, String message1, HttpStatus status) {
        super(message);
        this.message = message1;
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
