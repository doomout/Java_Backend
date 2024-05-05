package kr.co.shortenurlservice.infrastructure;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import kr.co.shortenurlservice.domain.ShortenUrl;
import kr.co.shortenurlservice.domain.ShortenUrlRepository;

public class MapShortenUrlRepository implements ShortenUrlRepository {
    private Map<String, ShortenUrl> shortenUrls = new ConcurrentHashMap<>();

    @Override
    public void saveShortenUrl(ShortenUrl shortenUrl) {
        shortenUrls.put(shortenUrl.getShortenUrlKey(), shortenUrl);
    }
}
