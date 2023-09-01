package com.challenge.vote.agenda.service.impl;

import com.challenge.vote.agenda.domain.dto.AgendaSaveOrUpdateDTO;
import com.challenge.vote.agenda.domain.dto.AgendaResponseDTO;
import com.challenge.vote.agenda.domain.entity.Agenda;
import com.challenge.vote.agenda.domain.exception.AgendaNotFoundRuntimeException;
import com.challenge.vote.agenda.repository.AgendaRepository;
import com.challenge.vote.agenda.service.AgendaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository repository;

    public AgendaServiceImpl(AgendaRepository repository) {
        this.repository = repository;
    }

    public List<AgendaResponseDTO> findAll(){
        log.trace("Find All");
        return this.repository.findAll()
                .stream().map(AgendaResponseDTO::new).toList();
    }

    public AgendaResponseDTO findById(final Long id){
        log.trace("Find By ID: {}", id);
        Optional<Agenda> agendaOptional = this.repository.findById(id);
        Agenda agenda = agendaOptional.orElseThrow(()-> new AgendaNotFoundRuntimeException("Not found " + id));
        return new AgendaResponseDTO(agenda);
    }

    public AgendaResponseDTO saveOrUpdate(final AgendaSaveOrUpdateDTO agendaSaveOrUpdateDTO){
        log.trace("Save Or Update");
        Agenda agenda = new Agenda(agendaSaveOrUpdateDTO.getTitle(), agendaSaveOrUpdateDTO.getDescription());
        this.repository.save(agenda);
        return new AgendaResponseDTO(agenda);
    }

    public void deleteById(final Long id){
        log.trace("Delete By ID: {}", id);
        this.repository.deleteById(id);
    }

    public List<AgendaResponseDTO> findToVote(){
        log.trace("Find Agenda to vote");
        return this.repository.findByIsAgendaApprovedIsNull()
                .stream().map(AgendaResponseDTO::new).toList();
    }

    public boolean check(Long id){
        log.trace("Check ID: {}", id);
        return this.repository.existsById(id);
    }

    public void setResult(Long id, Boolean result){
        log.trace("Getting the result from the agenda ID: {}", id);
        Optional<Agenda> agendaOptional = this.repository.findById(id);
        Agenda agenda = agendaOptional.orElseThrow(()-> new AgendaNotFoundRuntimeException("Not found " + id));
        agenda.setIsAgendaApproved(result);
        agenda.setTimeFinished(LocalDateTime.now());
        this.repository.save(agenda);
    }
}
