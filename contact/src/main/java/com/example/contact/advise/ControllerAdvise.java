package com.example.contact.advise;

import com.example.contact.exceptions.ApiException;
import com.example.contact.model.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ControllerAdvise {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Api> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new Api(message,400));
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Api> apiException(ApiException apiException){
        String message=apiException.getMessage();
        return ResponseEntity.status(400).body(new Api(message,400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api> exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(500).body(new Api("SERVER ERROR !",500));
    }
}
