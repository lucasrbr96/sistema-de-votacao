package com.challenge.vote.voting.session.repository;

import com.challenge.vote.voting.session.domain.entity.VotingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingSessionRepository extends JpaRepository<VotingSession, Long> {
    @Override
    boolean existsById(Long id);
    @Query("select case when count(session) > 0 then true else false end from VotingSession session where session.AgendaID = :id and session.status = 'IN_PROGRESS'")
    boolean isSessionInProgress(@Param("id") Long id);
}
