package kr.co.product.management.presentation;

import kr.co.product.management.application.SimpleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) { //@Valid 유효성 검사 추가
        //Product를 생성하고 리스트에 넣는 작업이 필요함
        return simpleProductService.add(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDto findProductById(@PathVariable Long id) {
        return simpleProductService.findById(id);
    }

    //전체 상품 목록 조회 or 이름으로 조회 
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDto> findProducts(
        //@RequestParam는 기본 속성이 필수로 받는 것이기에 파라미터가 없어도 되는 (required = false)를 명시해야 한다.
        @RequestParam(required = false) String name 
        ) { 
        if(null == name)
            return simpleProductService.findAll();

        return simpleProductService.findByNameContaining(name);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ProductDto updateProduct(
            @PathVariable Long id, //URI ​​템플릿에서 값을 추출
            @RequestBody ProductDto productDto // HTTP 요청 본문을 메서드 매개변수에 바인딩하는 데 사용
    ) {
        productDto.setId(id); //클라이언트가 요청 바디로 id를 넣지 않을 수도 있기 때문에 사용
        return simpleProductService.update(productDto);
    }

    //id를 받아서 삭제 한다.
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id) {
        simpleProductService.delete(id);
    }
}
