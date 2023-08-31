package com.challenge.vote.voting.session.domain.entity;

import com.challenge.vote.voting.session.domain.enumeration.VoteEnum;
import com.challenge.vote.voting.session.domain.enumeration.VotingStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VotingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long AgendaID;

    private LocalDateTime startedDateTime;

    private LocalDateTime finishDateTime;

    @Enumerated(EnumType.STRING)
    private VotingStatusEnum status;

    private VoteEnum poolResult;

}
