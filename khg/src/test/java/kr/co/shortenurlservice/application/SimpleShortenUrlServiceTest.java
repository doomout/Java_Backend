package kr.co.shortenurlservice.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.shortenurlservice.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateResponseDto;

@SpringBootTest
public class SimpleShortenUrlServiceTest {
    @Autowired
    private SimpleShortenUrlService simpleShortenUrlService;

    @Test
    @DisplayName("URL을 단축한 후 단축된 URL 키로 조회하면 원래 URL이 조회되어야 한다.")
    void shortenUrlAddTest() {
        // 테스트에 사용할 원본 URL
        String expectedOriginalUrl = "https://www.google.co.kr/";

        // 단축 URL 생성을 위한 DTO 객체 생성
        ShortenUrlCreateRequestDto shortenUrlCreateRequestDto = new ShortenUrlCreateRequestDto(expectedOriginalUrl);

        // 단축 URL 생성 요청 후 응답 DTO 받아오기
        ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = simpleShortenUrlService.generateShortenUrl(shortenUrlCreateRequestDto);

        // 생성된 단축 URL의 키 값 추출
        String shortenUrlKey = shortenUrlCreateResponseDto.getShortenUrlKey();
        
        // 단축 URL 키를 이용하여 원래 URL 조회
        String originalUrl = simpleShortenUrlService.getOriginalUrlByShortenUrlKey(shortenUrlKey);

        // 원래 URL과 예상한 URL이 일치하는지 확인
        assertTrue(originalUrl.equals(expectedOriginalUrl));
    }
}
