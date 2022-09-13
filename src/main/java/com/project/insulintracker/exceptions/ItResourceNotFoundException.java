package com.project.insulintracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItResourceNotFoundException extends RuntimeException{

    public ItResourceNotFoundException (String message){
        super(message);
    }
}
