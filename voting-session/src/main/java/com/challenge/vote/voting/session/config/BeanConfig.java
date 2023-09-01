package com.challenge.vote.voting.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
