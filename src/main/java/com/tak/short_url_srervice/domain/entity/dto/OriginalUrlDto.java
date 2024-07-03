package com.tak.short_url_srervice.domain.entity.dto;

import lombok.Data;

@Data
public class OriginalUrlDto {

    public OriginalUrlDto(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    private String originalUrl;
}
