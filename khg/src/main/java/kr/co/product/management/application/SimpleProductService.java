package kr.co.product.management.application;

import kr.co.product.management.domain.Product;
import kr.co.product.management.presentation.ProductDto;
import kr.co.product.management.infrastructure.ListProductRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service //@Service를 추가 함으로 해당 클래스는 스프링 프레임워크에 의해 생성되고 관리 된다.
public class SimpleProductService {
    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;
    
    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper ) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto) {
        //1. ProductDto 를 Product 로 변환하는 코드
        Product product = modelMapper.map(productDto, Product.class);

        //2. 레포지토리를 호출하는 코드
        Product savedProduct = listProductRepository.add(product);
        
        //3. Product 를 ProductDto로 변환하는 코드
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);
       
        //4. DTO를 반환하는 코드
        return savedProductDto;
    }
}
