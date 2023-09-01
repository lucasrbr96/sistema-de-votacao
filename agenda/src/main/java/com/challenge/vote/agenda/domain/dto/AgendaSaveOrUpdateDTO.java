package com.challenge.vote.agenda.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaSaveOrUpdateDTO {
    @NotNull
    private String description;
    @NotNull
    private String title;
}
