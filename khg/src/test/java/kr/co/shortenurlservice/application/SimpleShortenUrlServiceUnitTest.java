package kr.co.shortenurlservice.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import kr.co.shortenurlservice.domain.LackOfShortenUrlKeyException;
import kr.co.shortenurlservice.domain.ShortenUrl;
import kr.co.shortenurlservice.domain.ShortenUrlRepository;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateRequestDto;

@ExtendWith(MockitoExtension.class)
public class SimpleShortenUrlServiceUnitTest {
    
    @Mock
    private ShortenUrlRepository shortenUrlRepository;

    @InjectMocks
    private SimpleShortenUrlService simpleShortenUrlService;

    @Test
    @DisplayName("단축 URL이 계속 중복되면 LackOfShortenUrlKeyException 예외가 발생해야한다.")
    void throwLackOfShortenUrlKeyExceptionTest() {
        // 테스트에 사용할 단축 URL 생성 요청 DTO
        ShortenUrlCreateRequestDto shortenUrlCreateRequestDto = new ShortenUrlCreateRequestDto(null);

        // 단축 URL 키가 중복될 경우를 가정하여 mock 객체 설정
        when(shortenUrlRepository.findShortenUrlByShortenUrlKey(any())).thenReturn(new ShortenUrl(null, null));

        // 예외 발생 여부를 확인하기 위한 테스트
        Assertions.assertThrows(LackOfShortenUrlKeyException.class, () -> {
            simpleShortenUrlService.generateShortenUrl(shortenUrlCreateRequestDto);
        });
    }
}
