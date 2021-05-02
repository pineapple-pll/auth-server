package com.pineapple.authserver.advice;

import com.pineapple.authserver.exception.PineException;
import com.pineapple.authserver.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PineAdvice {

    @ExceptionHandler(PineException.class)
    public ResponseEntity exceptionHandler(PineException e) {
        ErrorResponse response = new ErrorResponse(e.getMemberErrorCode().getCode(), e.getMemberErrorCode().getDescription());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
