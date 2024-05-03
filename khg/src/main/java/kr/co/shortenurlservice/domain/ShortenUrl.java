package kr.co.shortenurlservice.domain;

public class ShortenUrl {
    private String originalUrl;  //원래 URL 저장
    private String shortenUrlKey; //단축된 URL의 키 값 저장
    private Long redirectCount; //리다이렉트 카운트 저장

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }
}
