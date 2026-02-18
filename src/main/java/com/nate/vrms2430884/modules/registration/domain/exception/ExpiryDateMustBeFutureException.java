package com.nate.vrms2430884.modules.registration.domain.exception;

public class ExpiryDateMustBeFutureException extends RuntimeException {
    public ExpiryDateMustBeFutureException(String message) { super(message); }
}
