package com.challenge.vote.voting.session.domain.exception;

public class InterruptedRuntimeException extends RuntimeException{
    public InterruptedRuntimeException(String message) {
        super(message);
    }
}
