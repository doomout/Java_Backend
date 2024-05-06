package kr.co.shortenurlservice.application;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.shortenurlservice.domain.LackOfShortenUrlKeyException;
import kr.co.shortenurlservice.domain.NotFoundShortenUrlException;
import kr.co.shortenurlservice.domain.ShortenUrl;
import kr.co.shortenurlservice.domain.ShortenUrlRepository;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateRequestDto;
import kr.co.shortenurlservice.presentation.ShortenUrlCreateResponseDto;
import kr.co.shortenurlservice.presentation.ShortenUrlInformationDto;

@Service
public class SimpleShortenUrlService {
    private ShortenUrlRepository shortenUrlRepository;
    
    @Autowired
    SimpleShortenUrlService(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    public ShortenUrlCreateResponseDto generateShortenUrl(ShortenUrlCreateRequestDto shortenUrlCreateRequestDto) {
        //1.원래의 URL 가져오기
        String originalUrl = shortenUrlCreateRequestDto.getOriginalUrl();

        //2. 단축 URL 생성 후 중복 체크
        String shortenUrlKey = generateShortenUrlKey();

        //3. 원래의 URL과 단축 URL 키를 통해 ShortenUrl 도메인 객체 생성
        ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey);

        //4. 생성된 ShortenUrl 을 레포지토리를 통해 저장
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        //5. ShortenUrl을 ShortenUrlCreateResponseDto로 변환하여 반환
        ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = new ShortenUrlCreateResponseDto(shortenUrl);

        return shortenUrlCreateResponseDto;
    }

    // 단축 URL 키를 이용하여 원래의 URL을 가져오는 메서드
    public String getOriginalUrlByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        if(null == shortenUrl)
            throw new NotFoundShortenUrlException();

        shortenUrl.increaseRedirectCount();
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        String originalUrl = shortenUrl.getOriginalUrl();

        return originalUrl;
    }

    // 단축 URL 키를 이용하여 단축 URL의 정보를 가져오는 메서드
    public ShortenUrlInformationDto getShortenUrlInformationByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        if(null == shortenUrl)
            throw new NotFoundShortenUrlException();

        ShortenUrlInformationDto shortenUrlInformationDto = new ShortenUrlInformationDto(shortenUrl);

        return shortenUrlInformationDto;
    }

    // 단축 URL 키를 생성하는 메서드
    private String generateShortenUrlKey()  {
        final int MAX_RETRY_COUNT = 5;
        int count = 0;

       //단축 URL 중복 체크
        while(count++ < MAX_RETRY_COUNT) {
            //단축 URL 생성 후 
            String shortenUrlKey = ShortenUrl.generateShortenUrlKey();
            //shortenUrlRepository 와 새로 생성한 shortenUrlKey를 비교한다.
            ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);
            if(null == shortenUrl) //단축 URL이 없으면 
                return shortenUrlKey;
        }

        throw new LackOfShortenUrlKeyException();
    }
}
