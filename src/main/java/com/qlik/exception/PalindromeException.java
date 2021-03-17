package com.qlik.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PalindromeException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ParagraphException.class)
	public ResponseEntity<Object> exceptionHandle(RuntimeException expException, WebRequest request)
	{
		return new ResponseEntity<>(expException.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
