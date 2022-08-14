package com.example.contact.exceptions;

public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }
}
