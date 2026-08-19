package com.gvscolombia.placetopay.exception.exceptions;

public class ConsultarSessionException extends RuntimeException {
    public ConsultarSessionException() {
        super();
    }

    public ConsultarSessionException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public ConsultarSessionException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ConsultarSessionException(String arg0) {
        super(arg0);
    }

    public ConsultarSessionException(Throwable arg0) {
        super(arg0);
    }
    
}
