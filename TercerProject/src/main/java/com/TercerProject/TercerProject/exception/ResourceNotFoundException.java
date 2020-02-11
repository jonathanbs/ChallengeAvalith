package com.TercerProject.TercerProject.exception;

public class ResourceNotFoundException extends Exception {
    private final static  long  serialVersionUID = 1L;

    public  ResourceNotFoundException(String message){
        super(message);
    }
}
