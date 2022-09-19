package net.wanhe.edusystem.exception;

public class TeaException extends Exception{
    public TeaException() {
    }

    public TeaException(String message) {
        super(message);
    }

    public TeaException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeaException(Throwable cause) {
        super(cause);
    }

    public TeaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
