package kr.co.product.management.application;

import kr.co.product.management.domain.Product;
import kr.co.product.management.presentation.ProductDto;
import kr.co.product.management.infrastructure.DatabaseProductRepository;
import kr.co.product.management.infrastructure.ListProductRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service //@Service를 추가 함으로 해당 클래스는 스프링 프레임워크에 의해 생성되고 관리 된다.
public class SimpleProductService {
    private DatabaseProductRepository databaseProductRepository;
    //private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;
    private ValidationService validationService;
    
    /* list 사용할 때
    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper, ValidationService validationService ) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }
    */
    @Autowired //DB 사용
    SimpleProductService(DatabaseProductRepository productRepository, ModelMapper modelMapper, ValidationService validationService
    ) {
        this.databaseProductRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    public ProductDto add(ProductDto productDto) {
        //1. ProductDto 를 Product 로 변환하는 코드
        Product product = modelMapper.map(productDto, Product.class);
        
        //2. 유효성 검사 코드
        validationService.checkValid(product); 

        //3. 레포지토리를 호출하는 코드
        Product savedProduct = databaseProductRepository.add(product);
        
        //4. Product 를 ProductDto로 변환하는 코드
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);
       
        //5. DTO를 반환하는 코드
        return savedProductDto;
    }

    public ProductDto findById(Long id) {
        Product product = databaseProductRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    //전체 상품 목록 조회 
    public List<ProductDto> findAll() {
        List<Product> products = databaseProductRepository.findAll();

        //Product -> ProductDto 으로 변환
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    //이름으로 조회
    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = databaseProductRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    //수정
    public ProductDto update(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product updatedProduct = databaseProductRepository.update(product);
        ProductDto updatedProductDto = modelMapper.map(updatedProduct, ProductDto.class);
        return updatedProductDto;
    }

    //삭제
    public void delete(Long id) {
        databaseProductRepository.delete(id);
    }
}
