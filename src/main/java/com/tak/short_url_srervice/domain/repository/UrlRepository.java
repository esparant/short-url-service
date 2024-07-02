package com.tak.short_url_srervice.domain.repository;

import com.tak.short_url_srervice.domain.entity.Url;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UrlRepository {

    private final EntityManager em;

    public Url save(Url url) {
        em.persist(url);
        return url;
    }

    public Url findById(Long id) {
        return em.find(Url.class, id);
    }

    public List<Url> findAll() {
        return em.createQuery("select u from Url u", Url.class).getResultList();
    }

    public Optional<Url> findByShortUrl(String shortUrl) {
        List<Url> result = em.createQuery("select u from Url u where u.shortUrl = :shortUrl", Url.class)
                .setParameter("shortUrl", shortUrl)
                .getResultList();

        return result.isEmpty() ? Optional.empty() : Optional.of(result.getFirst());

    }
}
