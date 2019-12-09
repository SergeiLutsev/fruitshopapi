package com.sergei.fruitshopapi.servises;

public class ResponseNotFoundException extends RuntimeException {
    public ResponseNotFoundException() {
    }

    public ResponseNotFoundException(String message) {
        super(message);
    }

    public ResponseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResponseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
