package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.order.Order;

import java.util.List;

//주문 응답 DTO
public class OrderResponseDto {
    private Long id; //주분  번호
    private List<ProductDto> orderedProducts; // 주문된 상품 목록
    private Integer totalPrice; //전체 주문 가격
    private String state; //주문 상태 코드

    public OrderResponseDto(Long id, List<ProductDto> orderedProducts, Integer totalPrice, String state) {
        this.id = id;
        this.orderedProducts = orderedProducts;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public List<ProductDto> getOrderedProducts() {
        return orderedProducts;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public String getState() {
        return state;
    }

    public static OrderResponseDto toDto(Order order) {
        List<ProductDto> orderedProductDtos = order.getOrderedProducts()
                .stream()
                .map(orderedProduct -> ProductDto.toDto(orderedProduct))
                .toList();

        OrderResponseDto orderResponseDto = new OrderResponseDto(
                order.getId(),
                orderedProductDtos,
                order.getTotalPrice(),
                order.getState()
        );

        return orderResponseDto;
    }
}
