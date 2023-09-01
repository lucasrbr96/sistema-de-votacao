package com.challenge.vote.voting.session.service;

import com.challenge.vote.voting.session.domain.enumeration.VoteEnum;
import com.challenge.vote.voting.session.domain.entity.VotingSession;
import com.challenge.vote.voting.session.domain.enumeration.VotingStatusEnum;
import com.challenge.vote.voting.session.repository.VoteRepository;
import com.challenge.vote.voting.session.repository.VotingSessionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Log4j2
public class VotingSessionService {

    private final VotingSessionRepository repository;

    private final AgendaRestClient agendaRestClient;

    private final VoteRepository voteRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // Pool de threads

    public VotingSessionService(VotingSessionRepository repository, AgendaRestClient agendaRestClient, ThreadPoolTaskScheduler taskScheduler, VoteRepository voteRepository) {
        this.repository = repository;
        this.agendaRestClient = agendaRestClient;
        this.voteRepository = voteRepository;
    }

    public VotingSession findById(final Long id){
        Optional<VotingSession> VotingSessionOptional = this.repository.findById(id);
        return VotingSessionOptional.orElseThrow(()-> new RuntimeException("Not found " + id));
    }

    public void openSession(final Long idAgenda,final Long seconds) throws ExecutionException, InterruptedException {
        if(!repository.existsById(idAgenda) && agendaRestClient.existsAgenda(idAgenda)){
            VotingSession votingSession =
                    new VotingSession(null, idAgenda, LocalDateTime.now(), null, VotingStatusEnum.IN_PROGRESS, null);
            this.repository.saveAndFlush(votingSession);

            executorService.submit(()->{
                log.info("Start vote");
                try {
                    Thread.sleep(seconds *1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                VotingSession votingSessionInProgress = findById(idAgenda);
                votingSessionInProgress.setStatus(VotingStatusEnum.CLOSED);
                VoteEnum voteEnum = voteRepository.sessionResult(votingSessionInProgress.getId());
                if(voteEnum == null){
                    voteEnum = VoteEnum.NO;
                }
                votingSessionInProgress.setPoolResult(voteEnum);
                this.agendaRestClient.sendResult(idAgenda, voteEnum);
                this.repository.save(votingSessionInProgress);
                log.info("Finish vote");
            });

        }else {
            throw new RuntimeException("Agenda does not exist or has already been closed " + idAgenda);
        }
    }

    public boolean isVotingProgress(Long id){
        return repository.isSessionInProgress(id);
    }

}