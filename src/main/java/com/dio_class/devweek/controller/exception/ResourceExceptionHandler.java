package com.dio_class.devweek.controller.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.cursomc.services.exceptions.DataIntegrityException;
import com.devsuperior.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest status) {

		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest status) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodArgumentNotValidException (MethodArgumentNotValidException e, HttpServletRequest status) {
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de Validação",
				LocalDateTime.now());

		for (FieldError x : e.getBindingResult().getFieldErrors()) 
			error.addError(x.getField(), x.getDefaultMessage());
		

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
