package com.challenge.vote.agenda.service;

import com.challenge.vote.agenda.domain.dto.AgendaRequestDTO;
import com.challenge.vote.agenda.domain.dto.AgendaResponseDTO;

import java.util.List;

public interface AgendaService {
    List<AgendaResponseDTO> findAll();
    AgendaResponseDTO findById(final Long id);
    AgendaResponseDTO saveOrUpdate(final AgendaRequestDTO agendaRequestDTO);
    void deleteById(final Long id);
    List<AgendaResponseDTO> findToVote();
    boolean check(Long id);
    void setResult(Long id, Boolean result);
}
