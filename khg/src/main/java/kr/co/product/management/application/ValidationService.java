package kr.co.product.management.application;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@Service
@Validated //@Valid 가 붙은 메서드 매개변수를 유효성 검사를 하겠다는 의미
public class ValidationService { 
    public  <T> void checkValid(@Valid T validationTarget) { 
        // do nothing
    }
}
