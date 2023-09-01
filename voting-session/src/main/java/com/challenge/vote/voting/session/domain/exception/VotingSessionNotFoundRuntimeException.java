package com.challenge.vote.voting.session.domain.exception;

public class VotingSessionNotFoundRuntimeException extends RuntimeException{
    public VotingSessionNotFoundRuntimeException(String message) {
        super(message);
    }
}
