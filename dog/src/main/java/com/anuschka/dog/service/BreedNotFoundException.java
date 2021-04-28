package com.anuschka.dog.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class BreedNotFoundException extends RuntimeException{
    public BreedNotFoundException() {
        super("Breed not found");
    }

    public BreedNotFoundException(String message) {
        super(message);
    }
}
