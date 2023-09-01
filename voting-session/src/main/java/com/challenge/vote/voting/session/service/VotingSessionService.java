package com.challenge.vote.voting.session.service;

import com.challenge.vote.voting.session.domain.entity.VotingSession;

public interface VotingSessionService {
    VotingSession findById(final Long id);
    void openSession(final Long idAgenda,final Long seconds);
    boolean isVotingProgress(Long id);
}
