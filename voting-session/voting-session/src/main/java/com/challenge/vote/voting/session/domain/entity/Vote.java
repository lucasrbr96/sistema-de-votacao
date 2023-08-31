package com.challenge.vote.voting.session.domain.entity;

import com.challenge.vote.voting.session.domain.enumeration.VoteEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private Long idAgenda;

    @Enumerated(EnumType.STRING)
    private VoteEnum status;
}
