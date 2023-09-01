package com.challenge.vote.voting.session.service.impl;

import com.challenge.vote.voting.session.domain.entity.Vote;
import com.challenge.vote.voting.session.domain.enumeration.VoteEnum;
import com.challenge.vote.voting.session.domain.exception.AlreadyVoteRuntimeException;
import com.challenge.vote.voting.session.domain.exception.SessionNotInProgressRuntimeException;
import com.challenge.vote.voting.session.repository.VoteRepository;
import com.challenge.vote.voting.session.service.VoteService;
import com.challenge.vote.voting.session.service.VotingSessionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class VoteServiceImpl implements VoteService {

    private final VotingSessionService votingSessionService;

    private final VoteRepository repository;

    public VoteServiceImpl(VotingSessionService votingSessionService, VoteRepository repository) {
        this.votingSessionService = votingSessionService;
        this.repository = repository;
    }

    public void vote(final Long idAgenda, final String cpf, String voted){
        log.trace("Vote to agenda {}", idAgenda);
        if(!votingSessionService.isVotingProgress(idAgenda)){
            throw new SessionNotInProgressRuntimeException("This session not in progress");
        }

        if(this.repository.existsByCpfAndIdAgenda(cpf, idAgenda)){
            throw new AlreadyVoteRuntimeException("Already Vote CPF ");
        }

        Vote vote = new Vote(null, cpf, idAgenda, VoteEnum.valueOf(voted));
        this.repository.save(vote);
    }
}