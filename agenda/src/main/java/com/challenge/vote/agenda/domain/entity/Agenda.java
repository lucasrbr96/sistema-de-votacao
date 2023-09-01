package com.challenge.vote.agenda.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Agenda {

    public Agenda(String description, String title) {
        this.description = description;
        this.title = title;
        this.setTimeCreated(LocalDateTime.now());
        this.isAgendaApproved = null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String title;

    private LocalDateTime timeCreated;

    private LocalDateTime timeFinished;

    private Boolean isAgendaApproved;

}
