package com.destructioncatalyst.einsteinspuzzle.exceptions;

public class MultipleRepeatException extends RuntimeException{

    public MultipleRepeatException() {
    }

    public MultipleRepeatException(String message) {
        super(message);
    }

    public MultipleRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public MultipleRepeatException(Throwable cause) {
        super(cause);
    }
}
