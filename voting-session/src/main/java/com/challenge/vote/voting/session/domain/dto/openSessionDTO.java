package com.challenge.vote.voting.session.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class openSessionDTO {

    private Long idAgenda;
    private Long second = 60L;
}
