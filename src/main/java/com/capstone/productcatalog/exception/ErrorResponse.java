package com.capstone.productcatalog.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final int statusCode;
    private final String message;

    ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
