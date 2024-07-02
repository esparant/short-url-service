package com.tak.short_url_srervice.domain.service;

import com.tak.short_url_srervice.domain.entity.Url;
import com.tak.short_url_srervice.domain.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository ur;

    @Transactional
    public Url saveUrl(Url url, HttpServletRequest request) {
        url.setShortUrl(isUniqueUrl(request));
        return ur.save(url);
    }

    private String isUniqueUrl(HttpServletRequest request) {
        String shortUrl;
        while(true) {
            shortUrl = createShortUrl(request);
            if (getUrlByShortUrl(shortUrl).isEmpty()) {
                return shortUrl;
            }
        }
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

    private String createShortUrl(HttpServletRequest request) {
        String hostUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .toUriString();
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        return hostUrl + "/" + uuid;
    }
}
