package com.project.insulintracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItBadRequestException extends RuntimeException{
    public ItBadRequestException(String message){
        super(message);
    }

}
