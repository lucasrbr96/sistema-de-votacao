package com.challenge.vote.voting.session.restController;

import com.challenge.vote.voting.session.domain.handlerError.ResponseHandlerError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RuntimeException.class})
    protected ResponseEntity<ResponseHandlerError> handleRuntime(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return ResponseEntity.badRequest().body(new ResponseHandlerError(bodyOfResponse));
    }

    @ExceptionHandler(value = { Exception.class})
    protected ResponseEntity<ResponseHandlerError> handleException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Unexpected error, call responsible";
        return ResponseEntity.internalServerError().body(new ResponseHandlerError(bodyOfResponse));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ResponseHandlerError> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError) error).getField();
            errors.add(new ResponseHandlerError(String.format("Field %s is required", fieldName)));
        });
        return ResponseEntity.badRequest().body(errors);
    }
}