package com.challenge.vote.voting.session.restController;

import com.challenge.vote.voting.session.domain.handlerError.ResponseHandlerError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RuntimeException.class})
    protected ResponseEntity<Object> handleRuntime(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return ResponseEntity.badRequest().body(new ResponseHandlerError(bodyOfResponse));
    }

    @ExceptionHandler(value = { Exception.class})
    protected ResponseEntity<ResponseHandlerError> handleException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Unexpected error, call responsible";
        return ResponseEntity.internalServerError().body(new ResponseHandlerError(bodyOfResponse));
    }
}