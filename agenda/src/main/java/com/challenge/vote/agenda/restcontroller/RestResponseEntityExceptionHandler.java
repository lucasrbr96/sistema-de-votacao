package com.challenge.vote.agenda.restcontroller;

import com.challenge.vote.agenda.domain.handlerError.ResponseHandlerError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
}
