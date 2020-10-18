package com.meli.lv3.model;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus httpStatus;
    private String message;

    public ErrorResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
