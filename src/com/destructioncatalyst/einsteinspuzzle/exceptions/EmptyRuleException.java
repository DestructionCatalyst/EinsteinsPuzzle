package com.destructioncatalyst.einsteinspuzzle.exceptions;

public class EmptyRuleException extends RuntimeException{

    public EmptyRuleException() {
    }

    public EmptyRuleException(String message) {
        super(message);
    }

    public EmptyRuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyRuleException(Throwable cause) {
        super(cause);
    }
}
