package kr.co.shortenurlservice.application;

import org.springframework.stereotype.Service;

import kr.co.shortenurlservice.domain.ShortenUrl;
import kr.co.shortenurlservice.domain.ShortenUrlRepository;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateResponseDto;
import kr.co.shortenurlservice.presentation.ShortenUrlInformationDto;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SimpleShortenUrlService {
    private ShortenUrlRepository shortenUrlRepository;

    @Autowired
    SimpleShortenUrlService(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    public ShortenUrlCreateResponseDto generateShortenUrl(
        ShortenUrlCreateRequestDto shortenUrlCreateRequestDto
    ) {
        //1.원래의 URL 가져오기
        String originalUrl = shortenUrlCreateRequestDto.getOriginalUrl();

        //2. 단축 URL 키  생성
        String shortenUrlKey = ShortenUrl.generateShortenUrlKey();

        //3. 원래의 URL과 단축 URL 키를 통해 ShortenUrl 도메인 객체 생성
        ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey);

        //4. 생성된 ShortenUrl 을 레포지토리를 통해 저장
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        //5. ShortenUrl을 ShortenUrlCreateResponseDto로 변환하여 반환
        ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = new ShortenUrlCreateResponseDto(shortenUrl);

        return shortenUrlCreateResponseDto;
    }

    public ShortenUrlInformationDto getShortenUrlInformationByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        ShortenUrlInformationDto shortenUrlInformationDto = new ShortenUrlInformationDto(shortenUrl);

        return shortenUrlInformationDto;
    }
}
