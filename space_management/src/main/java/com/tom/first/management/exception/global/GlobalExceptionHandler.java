package com.tom.first.management.exception.global;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tom.first.management.exception.AlreadyExistsException;
import com.tom.first.management.exception.CancelException;
import com.tom.first.management.exception.DuplicateException;
import com.tom.first.management.exception.InvalidDateException;
import com.tom.first.management.exception.InvalidFormatDate;
import com.tom.first.management.exception.NotAllowedException;
import com.tom.first.management.exception.NotFoundException;
import com.tom.first.management.exception.InternalException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<String> handleNotFoundException(RuntimeException exp) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(((CustomGlobalException) exp).getMsg());
	}

	@ExceptionHandler({ AlreadyExistsException.class, DuplicateException.class })
	public ResponseEntity<String> handleConflictException(RuntimeException exp) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(((CustomGlobalException) exp).getMsg());
	}

	@ExceptionHandler({ InvalidDateException.class })
	public ResponseEntity<String> handle(InvalidFormatDate exp) {
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(((CustomGlobalException) exp).getMsg());
	}
	
	@ExceptionHandler({ InvalidDateException.class })
	public ResponseEntity<String> handle( exp) {
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(((CustomGlobalException) exp).getMsg());
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