package com.tak.short_url_srervice.domain.entity;

import com.tak.short_url_srervice.domain.entity.dto.UrlDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class Url {

    public Url(UrlDto dto) {
        this.id = dto.getId();
        this.url = dto.getUrl();
    }

    public Url(String url, String shortUrl) {
        this.url = url;
        this.shortUrl = shortUrl;
    }

    @Id @GeneratedValue
    private Long id;

    @Column(length = 1557)
    private String url;

    @Setter
    @Column(unique = true, length = 1557)
    private String shortUrl;


}
