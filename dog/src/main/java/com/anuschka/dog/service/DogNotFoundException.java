package com.anuschka.dog.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class DogNotFoundException extends RuntimeException{
    public DogNotFoundException() {
        super("Dog not found");
    }

    public DogNotFoundException(String message) {
        super(message);
    }
}
