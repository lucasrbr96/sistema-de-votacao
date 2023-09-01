package com.challenge.vote.agenda.repository;

import com.challenge.vote.agenda.domain.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    List<Agenda> findByIsAgendaApprovedIsNull();
}
