package kr.co.shortenurlservice.presentation;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import kr.co.shortenurlservice.application.SimpleShortenUrlService;

// Spring MVC 애플리케이션에서 웹 계층(컨트롤러 등)을 테스트하기 위한 어노테이션
// Spring Boot 테스트 슬라이스 중 하나인 @WebMvcTest를 사용하여 웹 계층의 특정 컨트롤러를 테스트하는 데 사용
// @WebMvcTest를 사용하면 Spring MVC 애플리케이션의 웹 계층을 테스트할 때 필요한 빈들만 로드하여 더 빠르고 가볍게 테스트 가능 
// controllers 속성에는 테스트하려는 컨트롤러 클래스를 지정
@WebMvcTest(controllers = ShortenUrlRestController.class)
public class ShortenUrlRestControllerTest {
    
    @MockBean // 단순 URL 단축 서비스를 가짜로 모의화
    private SimpleShortenUrlService simpleShortenUrlService; 

    @Autowired // MockMvc를 주입
    private MockMvc mockMvc; 

    @Test
    @DisplayName("원래의 URL로 리다이렉트 되어야한다.")
    void redirectTest() throws Exception {
        String expectedOriginalUrl = "https://www.google.com/"; // 원래의 URL

        // 주어진 아무 키에 대해 모의 객체에서 원래의 URL 반환하도록 설정
        when(simpleShortenUrlService.getOriginalUrlByShortenUrlKey(any())).thenReturn(expectedOriginalUrl);

        
        mockMvc.perform(get("/any-key")) // "/any-key" 경로로 GET 요청 후
                .andExpect(status().isMovedPermanently()) // HTTP 상태가 올바르게 이동했는지 확인
                .andExpect(header().string("Location", expectedOriginalUrl));// 리다이렉션된 위치가 예상된 원래의 URL과 일치하는지 확인
    }

}
