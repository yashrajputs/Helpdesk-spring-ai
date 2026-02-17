package com.substirng.helpdesk.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.substirng.helpdesk.Service.AISevice;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/helpdesk")
public class AiController {

    private final AISevice service;


    @PostMapping
    public ResponseEntity<String> getResponse(@RequestBody String query) {
        
        return ResponseEntity.ok(service.getResponseFromAssistant(query));
    }

}
