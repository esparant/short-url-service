package com.tak.short_url_srervice.domain.entity.dto;

import com.tak.short_url_srervice.domain.entity.Url;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@Data
@ToString
public class UrlDto {

    public UrlDto(Url url) {
        this.id = url.getId();
        this.url = url.getUrl();
        this.shortUrl = url.getShortUrl();
    }

    private Long id;

    @URL(regexp = "^(https?|ftp):\\/\\/[^\\s/$.?#].[^\\s]*$", message = "올바른 url 을 입력하시오.")
    private String url;

    private String shortUrl;


}
