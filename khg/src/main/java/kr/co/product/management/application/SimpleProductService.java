package kr.co.product.management.application;

import kr.co.product.management.domain.Product;
import kr.co.product.management.infrastructure.ListProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service //@Service를 추가 함으로 해당 클래스는 스프링 프레임워크에 의해 생성되고 관리 된다.
public class SimpleProductService {
    private ListProductRepository listProductRepository;
    
    @Autowired
    SimpleProductService(ListProductRepository listProductRepository) {
        this.listProductRepository = listProductRepository;
    }

    public Product add(Product product) {
        Product savedProduct = listProductRepository.add(product);
        return savedProduct;
    }
}
