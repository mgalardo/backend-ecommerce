package com.miniecommerce.miniecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -4198723545778229937L;

    public NotFoundException() {
    }

    public NotFoundException(Exception e) {
        super(e);
    }

}
