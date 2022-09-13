package com.project.insulintracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)

public class ItAuthException extends RuntimeException {
    public ItAuthException(String message){
        super(message);
    }
}
