package app.prog.controller;

import app.prog.model.CoustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class CoustomExceptionController {
    @ExceptionHandler(CoustomException.class)
    public ResponseEntity<String>CoustomExceptions(CoustomException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
