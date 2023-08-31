package com.challenge.vote.voting.session.repository;

import com.challenge.vote.voting.session.domain.entity.Vote;
import com.challenge.vote.voting.session.domain.enumeration.VoteEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByCpfAndIdAgenda(String cpf, Long idAgenda);

    @Query("select vote.status from Vote vote where vote.id = :id group by vote.status order by vote.status desc limit 1")
    VoteEnum sessionResult(@Param("id") Long id);
}
