package org.aibles.userservice.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends AbstractException {
    public BadRequestException() {
        super("Check again input. Input is not in user list", HttpStatus.BAD_REQUEST);
    }
}
