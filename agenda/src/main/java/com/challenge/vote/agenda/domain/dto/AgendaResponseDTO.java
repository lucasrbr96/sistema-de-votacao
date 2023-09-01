package com.challenge.vote.agenda.domain.dto;

import com.challenge.vote.agenda.domain.entity.Agenda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaResponseDTO {
    public AgendaResponseDTO(Agenda agenda) {
        this.id = agenda.getId();
        this.title = agenda.getTitle();
        this.description = agenda.getDescription();
        this.timeCreated = agenda.getTimeCreated();
        this.timeFinished = agenda.getTimeFinished();
        this.isAgendaApproved = agenda.getIsAgendaApproved();
    }

    private Long id;
    private String description;
    private String title;
    private LocalDateTime timeCreated;
    private LocalDateTime timeFinished;
    private Boolean isAgendaApproved;
}
