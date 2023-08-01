package com.dailycodelearner.springboot.v2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private int fieldId;

    public UserNotFoundException(String resourceName,String fieldName,int fieldId){
        super(String.format("%s is not found with %s : '%s'",resourceName,fieldName,fieldId));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldId=fieldId;
    }
}
