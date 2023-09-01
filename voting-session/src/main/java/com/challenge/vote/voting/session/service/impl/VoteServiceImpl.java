package com.challenge.vote.voting.session.service.impl;

import com.challenge.vote.voting.session.domain.entity.Vote;
import com.challenge.vote.voting.session.domain.enumeration.VoteEnum;
import com.challenge.vote.voting.session.repository.VoteRepository;
import com.challenge.vote.voting.session.service.VoteService;
import com.challenge.vote.voting.session.service.VotingSessionService;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    private final VotingSessionService votingSessionService;

    private final VoteRepository repository;

    public VoteServiceImpl(VotingSessionService votingSessionService, VoteRepository repository) {
        this.votingSessionService = votingSessionService;
        this.repository = repository;
    }

    public void vote(final Long idAgenda, final String cpf, String voted){
        if(!votingSessionService.isVotingProgress(idAgenda)){
            throw new RuntimeException("This session not in progress");
        }

        if(this.repository.existsByCpfAndIdAgenda(cpf, idAgenda)){
            throw new RuntimeException("Already Vote CPF ");
        }

        Vote vote = new Vote(null, cpf, idAgenda, VoteEnum.valueOf(voted));
        this.repository.save(vote);
    }
}