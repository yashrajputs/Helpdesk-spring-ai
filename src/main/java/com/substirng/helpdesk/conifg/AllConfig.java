package com.substirng.helpdesk.conifg;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AllConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder

        .defaultSystem("Summerize the response with in 400 words.")

       .defaultAdvisors(new SimpleLoggerAdvisor()).build();
    }

}
