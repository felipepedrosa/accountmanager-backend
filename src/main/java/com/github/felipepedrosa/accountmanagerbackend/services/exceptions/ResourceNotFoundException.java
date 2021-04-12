package com.github.felipepedrosa.accountmanagerbackend.services.exceptions;

/**
 * Exception used in cases when was not possible to found specified resource.
 */
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1515464960557721696L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException() {
        super();
    }
}