package kr.co.khg.product.management;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        //Product를 생성하고 리스트에 넣는 작업이 필요함
        return product;
    }
}
