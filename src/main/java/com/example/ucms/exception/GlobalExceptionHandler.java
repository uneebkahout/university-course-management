package com.example.ucms.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(ResourceNotFoundException ex , HttpServletRequest request){
        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not found")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(errorResponse ,HttpStatus.NOT_FOUND);

}

@ExceptionHandler(MethodArgumentNotValidException.class)
public  ResponseEntity<ApiErrorResponse> handleValidation(MethodArgumentNotValidException ex , HttpServletRequest request){
    String message =ex.getBindingResult().getFieldErrors().stream().map(
            e -> e.getField()+ ":"+ e.getDefaultMessage()
    ).collect(Collectors.joining(","));

    ApiErrorResponse errorResponse =ApiErrorResponse.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .error("Bad Request")
            .path(request.getRequestURI())
            .message(message)
            .build();
    return  new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(Exception.class)
    public  ResponseEntity<ApiErrorResponse> handleGeneric(Exception exception , HttpServletRequest request){
        ApiErrorResponse errorResponse =ApiErrorResponse.builder()
                .error("Inter Server Error")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage() != null ? exception.getMessage() : "Something went wrong")
                .build();

        return  new ResponseEntity<>(errorResponse , HttpStatus.INTERNAL_SERVER_ERROR);
}

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .error("Method Not Allowed")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                  // assuming you have this field in ApiErrorResponse
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNoHandlerFound(NoHandlerFoundException ex, HttpServletRequest request) {
        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message("No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicateEntry(DataIntegrityViolationException ex, HttpServletRequest request) {
        // You can customize the message based on exception details if needed
        String message = "Duplicate entry detected: This record already exists.";

        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .status(HttpStatus.CONFLICT.value())  // 409 Conflict
                .error("Conflict")
                .message(message)
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
