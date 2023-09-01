package com.challenge.vote.voting.session.domain.exception;

public class AlreadyVoteRuntimeException extends RuntimeException{
    public AlreadyVoteRuntimeException(String message) {
        super(message);
    }
}
