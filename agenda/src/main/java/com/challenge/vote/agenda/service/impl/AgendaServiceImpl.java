package com.challenge.vote.agenda.service.impl;

import com.challenge.vote.agenda.domain.dto.AgendaRequestDTO;
import com.challenge.vote.agenda.domain.dto.AgendaResponseDTO;
import com.challenge.vote.agenda.domain.entity.Agenda;
import com.challenge.vote.agenda.repository.AgendaRepository;
import com.challenge.vote.agenda.service.AgendaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository repository;

    public AgendaServiceImpl(AgendaRepository repository) {
        this.repository = repository;
    }

    public List<AgendaResponseDTO> findAll(){
        return this.repository.findAll()
                .stream().map(AgendaResponseDTO::new).toList();
    }

    public AgendaResponseDTO findById(final Long id){
        Optional<Agenda> agendaOptional = this.repository.findById(id);
        Agenda agenda = agendaOptional.orElseThrow(()-> new RuntimeException("Not found " + id));
        return new AgendaResponseDTO(agenda);
    }

    public AgendaResponseDTO saveOrUpdate(final AgendaRequestDTO agendaRequestDTO){
        Agenda agenda = new Agenda(agendaRequestDTO.getTitle(), agendaRequestDTO.getDescription());
        this.repository.save(agenda);
        return new AgendaResponseDTO(agenda);
    }

    public void deleteById(final Long id){
        this.repository.deleteById(id);
    }

    public List<AgendaResponseDTO> findToVote(){
        return this.repository.findByIsAgendaApprovedIsNull()
                .stream().map(AgendaResponseDTO::new).toList();
    }

    public boolean check(Long id){
        return this.repository.existsById(id);
    }

    public void setResult(Long id, Boolean result){
        Optional<Agenda> agendaOptional = this.repository.findById(id);
        Agenda agenda = agendaOptional.orElseThrow(()-> new RuntimeException("Not found " + id));
        agenda.setIsAgendaApproved(result);
        agenda.setTimeFinished(LocalDateTime.now());
        this.repository.save(agenda);
    }
}
