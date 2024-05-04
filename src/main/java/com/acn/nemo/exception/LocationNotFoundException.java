package com.acn.nemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException() {
    }

    public LocationNotFoundException(String message) {
        super(message);
    }
}
