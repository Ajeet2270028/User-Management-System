package com.example.ums.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ums.exception.UserNotFoundByNameException;
import com.example.ums.exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandle{
	
    @ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(UserNotFoundException ex) {
    	return ResponseEntity.status(HttpStatus.NOT_FOUND)
    			.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "user not found for the given id"));
    	
//    	return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "user not found for the given id");
    }
    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleUserNotFoundByName(UserNotFoundByNameException ex) {
    	return ResponseEntity.status(HttpStatus.NOT_FOUND)
    			.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "user not found for the given name"));
    	
//    	return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "user not found for the given id");
    }
}
