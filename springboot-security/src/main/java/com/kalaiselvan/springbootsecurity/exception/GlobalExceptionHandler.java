package com.kalaiselvan.springbootsecurity.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.kalaiselvan.springbootsecurity.dto.ErrorMessage;
import com.kalaiselvan.springbootsecurity.dto.ResponseDto;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	 private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	    @ExceptionHandler(DepartmentNotFoundException.class)
	    public ResponseEntity<ResponseDto<ErrorMessage>> handleDepartmentNotFoundException(DepartmentNotFoundException ex, WebRequest request) {
	        logger.error("Department not found: {}", ex.getMessage(), ex);
	        ErrorMessage error = new ErrorMessage(ex.getMessage(), request.getDescription(false), "DEPT_NOT_FOUND");
	        var response = new ResponseDto<ErrorMessage>(404,error);
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(EmployeeNotFoundException.class)
	    public ResponseEntity<ResponseDto<ErrorMessage>> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
	        logger.error("Employee not found: {}", ex.getMessage(), ex);
	        ErrorMessage error = new ErrorMessage(ex.getMessage(), request.getDescription(false), "EMP_NOT_FOUND");
	        var response = new ResponseDto<ErrorMessage>(404,error);
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<ResponseDto<ErrorMessage>> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
	        String message = "Data integrity violation: " + ex.getMostSpecificCause().getMessage();
	        logger.error("Data integrity violation: {}", message, ex);
	        ErrorMessage error = new ErrorMessage(message, request.getDescription(false), "DATA_INTEGRITY_VIOLATION");
	        ResponseDto<ErrorMessage> response = new ResponseDto<ErrorMessage>(404,error);
	        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	    }

	    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
	    public ResponseEntity<ResponseDto<ErrorMessage>> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
	        String message = "Invalid argument type: " + ex.getName();
	        logger.error("Invalid argument type: {}", message, ex);
	        ErrorMessage error = new ErrorMessage(message, request.getDescription(false), "ARGUMENT_TYPE_MISMATCH");
	        var response = new ResponseDto<ErrorMessage>(404,error);
	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ResponseDto<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
	        logger.error("Method argument not valid: {}", errors, ex);
	        var response = new ResponseDto<Map<String, String>>(400,errors);
	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(ConstraintViolationException.class)
	    public ResponseEntity<ResponseDto<Map<String, String>>> handleConstraintViolationExceptions(ConstraintViolationException ex, WebRequest request) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getConstraintViolations().forEach(violation -> {
	            String fieldName = violation.getPropertyPath().toString();
	            String errorMessage = violation.getMessage();
	            errors.put(fieldName, errorMessage);
	        });
	        logger.error("Constraint violation: {}", errors, ex);
	        var response = new ResponseDto<Map<String, String>>(400,errors);
	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<ResponseDto<ErrorMessage>> handleRunTimeException(RuntimeException ex, WebRequest request) {
	        logger.error("Runtime exception: {}", ex.getMessage(), ex);
	        ErrorMessage error = new ErrorMessage(ex.getMessage(), request.getDescription(false), "RUNTIME_EXCEPTION");
	        var response = new ResponseDto<ErrorMessage>(500, error);
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ResponseDto<ErrorMessage>> handleGlobalException(Exception ex, WebRequest request) {
	        logger.error("Unhandled exception: {}", ex.getMessage(), ex);
	        ErrorMessage error = new ErrorMessage(ex.getMessage(), request.getDescription(false), "GLOBAL_EXCEPTION");
	        var response = new ResponseDto<ErrorMessage>(500,error);
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
