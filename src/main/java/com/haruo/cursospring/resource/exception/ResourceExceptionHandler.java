package com.haruo.cursospring.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.haruo.cursospring.services.exceptions.ObjectNotFoundException;

// Manipulador de excessão do recurso
@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Método <StandardError> onde será contido a informação do erro
	@ExceptionHandler(ObjectNotFoundException.class)  // Esse método recebe uma excessão: ObjectNotFoundException e as informação da requisição HttpServletRequest
	public ResponseEntity<StandardError>/*nome do método:*/ objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
	
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	// ExceptionHandler(ObjectNotFoundException.class) para indicar que é um tratador de excessao do tipo(.......)
}
