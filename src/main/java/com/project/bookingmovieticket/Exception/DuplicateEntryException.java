package com.project.bookingmovieticket.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import java.lang.*;


public class DuplicateEntryException extends RuntimeException{
    private final String message;


    public DuplicateEntryException(String message){
        super(message);
        this.message=message;
    }
}
