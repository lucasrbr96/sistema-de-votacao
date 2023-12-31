package com.challenge.vote.voting.session.restController;

import com.challenge.vote.voting.session.domain.dto.OpenSessionDTO;
import com.challenge.vote.voting.session.service.VotingSessionService;
import com.challenge.vote.voting.session.service.impl.VotingSessionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class VotingSessionRestController {
    private final VotingSessionService service;


    public VotingSessionRestController(VotingSessionServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void openSession(@RequestBody OpenSessionDTO voteDTO){
        this.service.openSession(voteDTO.getIdAgenda(), voteDTO.getSecond());
    }
}
