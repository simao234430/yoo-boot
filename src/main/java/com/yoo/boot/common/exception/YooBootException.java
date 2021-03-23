package com.yoo.boot.common.exception;

public class YooBootException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public YooBootException(String message){
        super(message);
    }

    public YooBootException(Throwable cause)
    {
        super(cause);
    }

    public YooBootException(String message,Throwable cause)
    {
        super(message,cause);
    }
}
