package com.example.userDemo.globalValidation;

import com.example.userDemo.exceptions.ResourceNotFoundException;
import com.example.userDemo.exceptions.UserAlreeadyExistsException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        System.out.println("AAAAAc BBBB");
        String message = ex.getMessage();
        System.out.println("message = " + message);
        System.out.println("ex ex"+ex);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreeadyExistsException.class)
    public ResponseEntity<String> userAlreadyExistsExceptionHandler(UserAlreeadyExistsException ex)
    {
        System.out.println("CCCC DDDD");
        String message = ex.getMessage();
        System.out.println("message = " + message);
        System.out.println("ex ex"+ex);
        return  new ResponseEntity<>(message,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidEx(MethodArgumentNotValidException ex)
    {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(err->{
            String fieldName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            errors.put(fieldName,message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
