package com.challenge.vote.voting.session.domain.exception;

public class NotExistOrAlreadyProcessRuntimeException extends RuntimeException{

    public NotExistOrAlreadyProcessRuntimeException(String message) {
        super(message);
    }
}
