package com.substirng.helpdesk.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AIService {

    private static final String API_KEY = System.getenv("PERPLEXITY_API_KEY");
    private static final String URL = "https://api.perplexity.ai/chat/completions";

    private final RestTemplate restTemplate = new RestTemplate();

    public String getResponseFromAssistant(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_KEY);

        Map<String, Object> body = Map.of(
                "model", "sonar",
                "messages", List.of(
                        Map.of("role", "user", "content", query)
                )
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);
            System.out.println("Status: " + response.getStatusCode());
            System.out.println("Body: " + response.getBody());
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }
}
