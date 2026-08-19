package com.gvscolombia.placetopay.exception.exceptions;

public class ObjectValidationException extends RuntimeException {
    public ObjectValidationException() {
        super();
    }

    public ObjectValidationException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public ObjectValidationException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ObjectValidationException(String arg0) {
        super(arg0);
    }

    public ObjectValidationException(Throwable arg0) {
        super(arg0);
    }
    
}
