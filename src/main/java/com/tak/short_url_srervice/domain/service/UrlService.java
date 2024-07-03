package com.tak.short_url_srervice.domain.service;

import com.tak.short_url_srervice.domain.entity.Url;
import com.tak.short_url_srervice.domain.repository.UrlRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository ur;

    @Transactional
    public Url saveUrl(Url url) {
        url.setShortUrl(isUniqueUrl());
        return ur.save(url);
    }

    public Url getUrl(Long id) {
        return ur.findById(id);
    }

    public List<Url> getUrls() {
        return ur.findAll();
    }

    public Optional<Url> getUrlByShortUrl(String shortUrl) {
        return ur.findByShortUrl(shortUrl);
    }

    private String createShortUrl() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private String isUniqueUrl() {
        String shortUrl;
        while(true) {
            shortUrl = createShortUrl();
            if (getUrlByShortUrl(shortUrl).isEmpty()) {
                return shortUrl;
            }
        }
    }
}
