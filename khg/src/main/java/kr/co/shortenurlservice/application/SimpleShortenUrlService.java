package kr.co.shortenurlservice.application;

import org.springframework.stereotype.Service;

import kr.co.shortenurlservice.domain.ShortenUrl;
import kr.co.shortenurlservice.domain.ShortenUrlRepository;
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

    public ShortenUrlCreateResponseDto generateShortenUrl() {
        //1. 단축 URL 키  생성
        //2. 원래의 URL과 단축 URL 키를 통해 ShortenUrl 도메인 객체 생성
        //3. 생성된 ShortenUrl 을 레포지토리를 통해 저장
        //4. ShortenUrl을 ShortenUrlCreateResponseDto로 변환하여 반환
        return null;
    }

    public ShortenUrlInformationDto getShortenUrlInformationByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        ShortenUrlInformationDto shortenUrlInformationDto = new ShortenUrlInformationDto(shortenUrl);

        return shortenUrlInformationDto;
    }
}
