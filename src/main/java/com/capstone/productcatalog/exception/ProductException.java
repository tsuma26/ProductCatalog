package com.capstone.productcatalog.exception;

import org.springframework.http.HttpStatus;

public class ProductException extends Exception {
    private HttpStatus statusCode;

    public ProductException(HttpStatus status, String message) {
        super(message);
    }

    public HttpStatus getHttpStatus() {
        return statusCode;
    }
}
