package com.challenge.vote.voting.session.domain.handlerError;

import lombok.Data;

@Data
public class ResponseHandlerError {
    public ResponseHandlerError(String message) {
        this.message = message;
    }

    private String message;
}
