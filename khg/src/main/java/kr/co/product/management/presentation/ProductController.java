package kr.co.product.management.presentation;

import org.springframework.web.bind.annotation.*;

import kr.co.product.management.domain.Product;

@RestController
public class ProductController {
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        //Product를 생성하고 리스트에 넣는 작업이 필요함
        return product;
    }
}
