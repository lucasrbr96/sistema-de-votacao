package com.challenge.vote.agenda.domain.handlerError;

import lombok.Data;

@Data
public class ResponseHandlerError {
    private String message;
    public ResponseHandlerError(String message) {
        this.message = message;
    }

}
