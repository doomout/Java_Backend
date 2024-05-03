package kr.co.shortenurlservice.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class ShortenUrlRestController {
    //단축 URL 생성
    @RequestMapping(value = "/shortenUrl", method = RequestMethod.POST)
    public ResponseEntity<ShortenUrlCreateResponseDto> createShortenUrl(
            @Valid @RequestBody ShortenUrlCreateRequestDto shortenUrlCreateRequestDto
    )  {
        return  ResponseEntity.ok().body(null);
    } 

    //단축 URL 리다이렉트
    @RequestMapping(value = "/{shortenUrlKey}", method = RequestMethod.GET)
    public ResponseEntity<?> redirectShortenUrl( 
            @PathVariable String shortenUrlKe
    )  {
        return ResponseEntity.ok().body(null);
    }

    //단축 URL 정보 조회
    @RequestMapping(value = "/shortenUrl/{shortenUrlKey}", method = RequestMethod.GET)
    public ResponseEntity<ShortenUrlInformationDto> getShortenUrlInformation(
            @PathVariable String shortenUrlKey
    ) {
        return ResponseEntity.ok().body(null);
    }
}
