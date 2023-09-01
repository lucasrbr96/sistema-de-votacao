package com.challenge.vote.voting.session.service;

public interface VoteService {
    void vote(final Long idAgenda, final String cpf, String voted);
}
