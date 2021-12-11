package org.aibles.userservice.service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractException {

    public NotFoundException() {
        super("ID is not found. Please try again with other Id.", HttpStatus.NOT_FOUND);
    }
}
