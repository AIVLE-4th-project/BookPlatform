package com.example.BookPlatform.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {
    @Value("${openai.api.key}")
    private String openAiApiKey;

    public String generateImage(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(openAiApiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("prompt", prompt);
        body.put("n", 1);
        body.put("size", "1024x1024");
        body.put("model", "dall-e-3");
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                "https://api.openai.com/v1/images/generations",
                request,
                Map.class
        );

        List<Map<String, String>> data = (List<Map<String, String>>) response.getBody().get("data");
        return data.get(0).get("url");
    }
}
