package com.example.BookPlatform.controller;

import com.example.BookPlatform.dto.request.ImageRequestDTO;
import com.example.BookPlatform.dto.response.ImageResponseDTO;
import com.example.BookPlatform.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/generate")
    public ResponseEntity<ImageResponseDTO> generateImage(@RequestBody ImageRequestDTO request) {
        String imageUrl = imageService.generateImage(request.getPrompt());
        return ResponseEntity.ok(new ImageResponseDTO(imageUrl));
    }
}
