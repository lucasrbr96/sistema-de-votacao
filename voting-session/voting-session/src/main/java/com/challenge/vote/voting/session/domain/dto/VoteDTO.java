package com.challenge.vote.voting.session.domain.dto;

import com.challenge.vote.voting.session.domain.enumeration.VoteEnum;
import lombok.Data;

@Data
public class VoteDTO {
    private String cpf;
    private Long idAgenda;
    private String vote;
}
