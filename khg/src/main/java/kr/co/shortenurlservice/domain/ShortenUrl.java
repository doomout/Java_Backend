package kr.co.shortenurlservice.domain;

import java.util.Random;

public class ShortenUrl {
    private String originalUrl;  //원래 URL 저장
    private String shortenUrlKey; //단축된 URL의 키 값 저장
    private Long redirectCount; //리다이렉트 카운트 저장

    public ShortenUrl(String originalUrl, String shortenUrlKey) {
        this.originalUrl = originalUrl;
        this.shortenUrlKey = shortenUrlKey;
        this.redirectCount = 0L;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }

    public void increaseRedirectCount() {
        this.redirectCount = this.redirectCount + 1;
    }

    public static String generateShortenUrlKey() {
        //Base56 문자열 사용
        String base56Characters = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
        Random random = new Random();
        StringBuilder shortenUrlKey = new StringBuilder();

        //7 글자로 제한
        for(int count = 0; count < 8; count++) {
            int base56CharactersIndex = random.nextInt(0, base56Characters.length());
            char base56Character = base56Characters.charAt(base56CharactersIndex);

            shortenUrlKey.append(base56Character);
        }

        return shortenUrlKey.toString();
    }
}
