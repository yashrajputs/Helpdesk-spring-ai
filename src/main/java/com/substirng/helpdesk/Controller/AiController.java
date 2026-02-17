package com.substirng.helpdesk.Controller;

import com.substirng.helpdesk.Service.AIService;


import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

    private final AIService service;


    @PostMapping
    public ResponseEntity<String> getResponse(@RequestBody String query) {
        
        return ResponseEntity.ok(service.getResponseFromAssistant(query));
    }

}
