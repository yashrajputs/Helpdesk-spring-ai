package com.substirng.helpdesk.Service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class AISevice {

    private final ChatClient chatClient;

    public String getResponseFromAssistant(String query) {
        return this.chatClient
        .prompt()
        .user(query)
        .call()
        .content();
    }

}
