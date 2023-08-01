package com.dailycodelearner.springboot.v2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException userNotFoundException,
                                                                    WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setLocalDateTime(LocalDateTime.now());
        errorDetails.setMessage(userNotFoundException.getMessage());
        errorDetails.setPath(webRequest.getDescription(true));
        errorDetails.setErrorcode("User_Not_Found");

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception exception,
                                                                    WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setLocalDateTime(LocalDateTime.now());
        errorDetails.setMessage(exception.getMessage());
        errorDetails.setPath(webRequest.getDescription(true));
        errorDetails.setErrorcode("Internal_Server_Error");

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
