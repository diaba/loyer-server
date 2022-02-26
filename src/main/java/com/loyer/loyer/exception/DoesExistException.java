package com.loyer.loyer.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DoesExistException extends RuntimeException {
    public DoesExistException(String locataire) {
        super(locataire);
    }
}
