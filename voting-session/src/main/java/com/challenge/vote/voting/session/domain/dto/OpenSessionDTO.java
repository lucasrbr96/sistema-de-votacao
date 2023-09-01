package com.challenge.vote.voting.session.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenSessionDTO {
    @NotNull
    private Long idAgenda;
    private Long second = 60L;
}
