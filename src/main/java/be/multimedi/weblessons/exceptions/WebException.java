package be.multimedi.weblessons.exceptions;

import java.util.Arrays;

public class WebException extends RuntimeException {
    public WebException() {
        super();
    }

    public WebException(String message) {
        super(message);
    }

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebException(Throwable cause) {
        super(cause);
    }

    protected WebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String print() {
        String message = Arrays
                .stream(this.getStackTrace())
                .map(f -> f.toString())
                .reduce((f, s) -> f += s + "\n")
                .get();
        return message;
    }
}
