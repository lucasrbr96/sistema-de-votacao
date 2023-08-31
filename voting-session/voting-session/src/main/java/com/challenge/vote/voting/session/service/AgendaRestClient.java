package com.challenge.vote.voting.session.service;

import com.challenge.vote.voting.session.domain.enumeration.VoteEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class AgendaRestClient {

    private final RestTemplate restTemplate;

    @Value("${agenda.url}")
    private String agendaURL;

    public AgendaRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean existsAgenda(Long id){
        ResponseEntity<Boolean> response = restTemplate.getForEntity(agendaURL.concat("v1/check/" + id), Boolean.class);
        if(response.getStatusCode().is5xxServerError()){
            throw new RuntimeException("Error in call to API agenda");
        }

        if (response.getStatusCode().is4xxClientError()){
            throw new RuntimeException("Not exist this agenda or Already voted" + id);
        }

        return response.getBody();
    }

    public void sendResult(Long id, VoteEnum poolResult){
        Boolean result = poolResult.equals(VoteEnum.YES) ? Boolean.TRUE : Boolean.FALSE;
        restTemplate.put(agendaURL.concat("v1/result/" + id), result);
    }
}
