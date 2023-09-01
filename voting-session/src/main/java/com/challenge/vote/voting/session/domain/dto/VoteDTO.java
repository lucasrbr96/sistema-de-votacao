package com.challenge.vote.voting.session.domain.dto;

import com.challenge.vote.voting.session.domain.enumeration.VoteEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoteDTO {
    @NotNull
    private String cpf;
    @NotNull
    private Long idAgenda;
    @NotNull
    private String vote;
}
