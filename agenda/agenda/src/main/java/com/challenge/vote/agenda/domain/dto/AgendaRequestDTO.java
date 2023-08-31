package com.challenge.vote.agenda.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaRequestDTO {
    private String description;
    private String title;
}
