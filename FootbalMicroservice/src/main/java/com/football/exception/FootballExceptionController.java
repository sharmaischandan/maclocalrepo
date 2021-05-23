package com.football.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FootballExceptionController {

	@ExceptionHandler(value = RecordNotfoundException.class)
	   public ResponseEntity<Object> exception(RecordNotfoundException exception) {
	      return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
	   }
}
