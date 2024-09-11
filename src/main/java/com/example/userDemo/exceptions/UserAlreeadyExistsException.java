package com.example.userDemo.exceptions;

public class UserAlreeadyExistsException extends RuntimeException{

    public UserAlreeadyExistsException()
    {
        super();
    }
    public UserAlreeadyExistsException(String message)
    {
        super(message);
    }
}
