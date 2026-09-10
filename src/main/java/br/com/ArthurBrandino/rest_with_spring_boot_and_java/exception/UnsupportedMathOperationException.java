package br.com.ArthurBrandino.rest_with_spring_boot_and_java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class UnsupportedMathOperationException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Please set a numeric value!";

    public UnsupportedMathOperationException()
    {
        super(DEFAULT_MESSAGE);
    }

    public UnsupportedMathOperationException(String message){
        super(message);
    }
}
