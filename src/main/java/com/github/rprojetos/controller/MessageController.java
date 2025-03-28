package com.github.rprojetos.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @PostMapping("/api/messages")
    public ResponseEntity<Void> receiveMessage(@RequestBody MessageDTO message) {
        System.out.println("Mensagem recebida: " + message.getMessage());
        return ResponseEntity.ok().build();
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class MessageDTO {
        private String message;
    }
}
