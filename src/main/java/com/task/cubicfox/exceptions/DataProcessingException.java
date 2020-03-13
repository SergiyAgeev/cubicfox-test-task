package com.task.cubicfox.exceptions;

public class DataProcessingException extends RuntimeException {

    public DataProcessingException(String message) {
        super(message);
    }

    public DataProcessingException(String message, Exception e) {
        super(message, e);
    }
}
