package com.vstec.usuario.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> handle(UserAlreadyExistsException exp) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMsg());
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handle(UserNotFoundException exp) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exp.getMsg());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exp) {
		var errors = new HashMap<String, String>();
		exp.getBindingResult().getAllErrors().forEach(error -> {
			var fieldName = ((FieldError) error).getField();
			var errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
	}

}
