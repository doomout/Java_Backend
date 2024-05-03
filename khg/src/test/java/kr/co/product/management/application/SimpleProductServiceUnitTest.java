package kr.co.product.management.application;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import kr.co.product.management.domain.Product;
import kr.co.product.management.domain.ProductRepository;
import kr.co.product.management.presentation.ProductDto;

@ExtendWith(MockitoExtension.class) //스프링 부트 애플리케이션을 실행시키지 않고도 테스트 코드를 실행 가능하게 한다.
public class SimpleProductServiceUnitTest {
    @Mock //모의 객체
    private ProductRepository productRepository;

    @Mock //모의 객체
    private ValidationService validationService;

    @InjectMocks  //실제 인스턴스 생성해서 객체 사용 가능
    private SimpleProductService simpleProductService;

    @Test
    @DisplayName("상품 추가 후에는 추가된 상품이 반환되어야한다.")
    void productAddTest () {
        ProductDto productDto = new ProductDto("연필", 300, 20);
        Long PRODUCT_ID = 1L;

        Product product = ProductDto.toEntity(productDto);
        product.setId(PRODUCT_ID);

        //모의객체가 when에 해당하는 동작을 수행할 때 thenReturn에 있는 값을 반환한다.
        //productRepository.add(아무값)이 들어가면 product을 반환한다.
        when(productRepository.add(any())).thenReturn(product);

        ProductDto savedProductDto = simpleProductService.add(productDto);

        assertTrue(savedProductDto.getId().equals(PRODUCT_ID));
        assertTrue(savedProductDto.getName().equals(productDto.getName()));
        assertTrue(savedProductDto.getPrice().equals(productDto.getPrice()));
        assertTrue(savedProductDto.getAmount().equals(productDto.getAmount()));
    }
}
