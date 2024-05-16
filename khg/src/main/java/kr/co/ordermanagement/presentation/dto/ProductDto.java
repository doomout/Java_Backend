package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.product.Product;

// ProductDto 클래스는 데이터 전송 객체로, Presentation Layer와의 통신을 위한 객체
// Presentation Layer (예: REST API 컨트롤러)와 Service Layer 간에 데이터를 주고받을 때 사용
// 도메인 모델과 Presentation Layer 간의 결합을 최소화하고, 
// 데이터의 전송을 단순화하여 클라이언트와의 상호작용을 효율적으로 관리
public class ProductDto {
    private Long id; //제품 번호
    private String name;  //제품명
    private Integer price; //가격
    private Integer amount; //재고량

    public ProductDto(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public static ProductDto toDto(Product product) {  //제품 객체를 DTO로 변환
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAmount()
        );

        return productDto;  //제품에 대한 정보를 클라이언트에게 반환
    }
}
