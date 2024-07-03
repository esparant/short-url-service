package com.tak.short_url_srervice.domain.controller;

import com.tak.short_url_srervice.domain.entity.Url;
import com.tak.short_url_srervice.domain.service.UrlService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
public class UrlRestController {

    private final UrlService urlService;

    @GetMapping("/{shortUrl}")
    public RedirectView getUrl(@PathVariable("shortUrl") String shortUrl) {
        Optional<Url> url = urlService.getUrlByShortUrl(shortUrl);

        return url.map(value -> new RedirectView(value.getUrl())).orElseGet(() -> new RedirectView("short-url-service"));
    }
}
