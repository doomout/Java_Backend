package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.order.OrderedProduct;


// OrderedProductDto 클래스는 주문된 제품에 대한 정보를 전달하기 위한 데이터 전송 객체
// 주로 Presentation Layer와 Service Layer 간의 데이터 교환을 위해 사용
// DTO 객체는 Presentation Layer에서 필요한 정보만을 간결하게 전달하는 역할
// 도메인 모델과 Presentation Layer 사이의 의존성을 최소화하고, 시스템의 유연성과 확장성을 높임
public class OrderedProductDto { //주문된 제품의 정보
   private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public OrderedProductDto(Long id, String name, Integer price, Integer amount) {
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

    public static OrderedProductDto toDto(OrderedProduct orderedProduct) { //OrderedProduct를 DTO로 변환
        OrderedProductDto orderedProductDto = new OrderedProductDto(
                orderedProduct.getId(),
                orderedProduct.getName(),
                orderedProduct.getPrice(),
                orderedProduct.getAmount()
        );

        return orderedProductDto;
    } 
}
