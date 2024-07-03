package com.tak.short_url_srervice.domain.entity.dto;

import com.tak.short_url_srervice.domain.entity.Url;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@NoArgsConstructor
@Data
@ToString
public class UrlDto {

    public UrlDto(Url url, HttpServletRequest request) {
        this.id = url.getId();
        this.url = url.getUrl();
        shortUrl = getDefaultHostUrl(request) + "/" + url.getShortUrl();
    }

    private Long id;

    @URL(regexp = "^(https?|ftp):\\/\\/[^\\s/$.?#].[^\\s]*$", message = "올바른 url 을 입력하시오.")
    private String url;

    private String shortUrl;

    private String getDefaultHostUrl(HttpServletRequest request) {
        return ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build().toUriString();
    }
}
