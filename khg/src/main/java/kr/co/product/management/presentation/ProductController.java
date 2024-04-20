package kr.co.product.management.presentation;

import kr.co.product.management.application.SimpleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        //Product를 생성하고 리스트에 넣는 작업이 필요함
        return simpleProductService.add(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDto findProductById(@PathVariable Long id) {
        return simpleProductService.findById(id);
    }

    //전체 상품 목록 조회 
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDto> findProducts() {
        return simpleProductService.findAll();
    }
}
