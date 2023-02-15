package com.example.cardcontroller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    @PostMapping
    public ResponseEntity<String> generateToken(@RequestBody String cardNumber) throws JsonProcessingException {
        String token = TokenGenerator.generateToken(cardNumber);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(response), headers, HttpStatus.OK);
    }
}


