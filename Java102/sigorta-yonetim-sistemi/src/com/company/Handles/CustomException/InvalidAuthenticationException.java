package com.company.Handles.CustomException;

public class InvalidAuthenticationException extends Exception{
    public InvalidAuthenticationException(String message) {
        super(message);
    }
}
