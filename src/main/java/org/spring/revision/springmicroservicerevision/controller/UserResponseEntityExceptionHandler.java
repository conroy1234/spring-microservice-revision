package org.spring.revision.springmicroservicerevision.controller;

import java.time.LocalDate;

import org.spring.revision.springmicroservicerevision.bean.ExceptionResponse;
import org.spring.revision.springmicroservicerevision.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class UserResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public final ResponseEntity<ExceptionResponse> handleNotFoundException(UserNotFoundException exception,
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getBindingResult().toString(),
				request.getDescription(true));

		return new ResponseEntity<Object>(exceptionResponse, status);
	}
}
