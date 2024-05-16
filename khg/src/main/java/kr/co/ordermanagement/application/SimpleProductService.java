package kr.co.ordermanagement.application;

import java.util.List;

import kr.co.ordermanagement.domain.product.Product;
import kr.co.ordermanagement.domain.product.ProductRepository;
import kr.co.ordermanagement.presentation.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {
    private ProductRepository productRepository;

    @Autowired
    SimpleProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 모든 제품 조회
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll(); //전체 Product 조회
        List<ProductDto> productDtos = products.stream()
                .map(product -> ProductDto.toDto(product))
                .toList();
        return productDtos;
    }
}
