package com.g2tech.exception;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(value = { TransactionSystemException.class })
    protected ResponseEntity<Object> handleConflict(TransactionSystemException ex, WebRequest request) {
        ex.printStackTrace();
        Throwable cause = ex.getRootCause();

        if (cause instanceof ConstraintViolationException) {
           Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) cause).getConstraintViolations();
           // iterate the violations to create your JSON user friendly message
           String msg = "test error";
           Map<String, Object> body = new LinkedHashMap<String,Object>();
           body.put("timestamp", new Date());
           body.put("status", HttpStatus.BAD_REQUEST);

           //Get all errors
           List<String> errors = constraintViolations.stream()
                   .map(x -> x.getMessage())
                   .collect(Collectors.toList());

           body.put("errors", errors);

           return handleExceptionInternal(ex, body , new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
      }
        return null;
    }
	
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return error;
	}

}