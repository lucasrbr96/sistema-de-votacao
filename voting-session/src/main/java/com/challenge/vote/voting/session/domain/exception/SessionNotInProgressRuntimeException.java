package com.challenge.vote.voting.session.domain.exception;

public class SessionNotInProgressRuntimeException extends RuntimeException{

    public SessionNotInProgressRuntimeException(String message) {
        super(message);
    }
}
