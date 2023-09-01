package com.challenge.vote.agenda.domain.exception;

public class AgendaNotFoundRuntimeException extends RuntimeException{
    public AgendaNotFoundRuntimeException(String message) {
        super(message);
    }
}
