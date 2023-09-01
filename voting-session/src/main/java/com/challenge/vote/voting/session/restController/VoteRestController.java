package com.challenge.vote.voting.session.restController;

import com.challenge.vote.voting.session.domain.dto.VoteDTO;
import com.challenge.vote.voting.session.service.VoteService;
import com.challenge.vote.voting.session.service.impl.VoteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/vote")
@RestController
public class VoteRestController {
    private final VoteService service;


    public VoteRestController(VoteServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void vote(@RequestBody VoteDTO voteDTO){
        this.service.vote(voteDTO.getIdAgenda(), voteDTO.getCpf(), voteDTO.getVote());
    }
}
