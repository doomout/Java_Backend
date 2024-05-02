package kr.co.product.management.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import kr.co.product.management.domain.EntityNotFoundException;
import kr.co.product.management.presentation.ProductDto;

import static org.junit.jupiter.api.Assertions.*; //테스트 성공, 실패 자동체크
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SpringBootTest //통합 테스트를 위해 사용
@ActiveProfiles("prod") //prod : DB 사용, test: list 사용
public class SimpleProductServiceTest {
    @Autowired //테스트 코드에서는 필드에 바로 주입해도 무관하다.
    SimpleProductService simpleProductService;

    @Transactional //DB 테스트시 실 데이터가 안들어가도록 사용
    @Test //해당 메서드가 테스트 코드라는 것을 의미
    @DisplayName("상품을 추가한 후 id로 조회하면 해당 상품이 조회되어야한다.") //테스트 코드의 이름을 지정할 수 있다.
    void productAddAndFindByIdTest() {
        ProductDto productDto = new ProductDto("연필", 300, 20);

        ProductDto savedProductDto = simpleProductService.add(productDto);
        Long savedProductId = savedProductDto.getId();

        ProductDto foundProductDto = simpleProductService.findById(savedProductId);

        assertTrue(savedProductDto.getId().equals(foundProductDto.getId()));
        assertTrue(savedProductDto.getName().equals(foundProductDto.getName()));
        assertTrue(savedProductDto.getPrice().equals(foundProductDto.getPrice()));
        assertTrue(savedProductDto.getAmount().equals(foundProductDto.getAmount()));
    }
    @Test
    @DisplayName("존재하지 않는 상품 id로 조회하면 EntityNotFoundException이 발생해야한다.")
    void findProductNotExistIdTest () {
        Long notExistId = -1L; //존재할 수 없는 id 번호

        assertThrows(EntityNotFoundException.class, () -> {
            simpleProductService.findById(notExistId);
        });
    }
}
