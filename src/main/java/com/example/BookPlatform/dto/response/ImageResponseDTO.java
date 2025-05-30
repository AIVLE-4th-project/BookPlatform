package com.example.BookPlatform.dto.response;

public class ImageResponseDTO {
    private String imageUrl;

    public ImageResponseDTO(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
