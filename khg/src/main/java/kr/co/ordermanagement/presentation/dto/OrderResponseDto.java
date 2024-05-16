package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.order.Order;
import kr.co.ordermanagement.domain.order.State;

import java.util.List;

//주문 응답 DTO
public class OrderResponseDto {
    private Long id; //주문  번호
    private List<OrderedProductDto> orderedProducts; // 주문된 상품 목록
    private Integer totalPrice; //전체 주문 가격
    private State state; //주문 상태 코드

    public OrderResponseDto(Long id, List<OrderedProductDto> orderedProducts, Integer totalPrice, State state) {
        this.id = id;
        this.orderedProducts = orderedProducts;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public List<OrderedProductDto> getOrderedProducts() {
        return orderedProducts;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public State getState() {
        return state;
    }

    public static OrderResponseDto toDto(Order order) { //주문 객체를 DTO로 변환
        List<OrderedProductDto> orderedProductDtos = order.getOrderedProducts()
                .stream()
                .map(orderedProduct -> OrderedProductDto.toDto(orderedProduct))
                .toList();

        OrderResponseDto orderResponseDto = new OrderResponseDto(
                order.getId(),
                orderedProductDtos,
                order.getTotalPrice(),
                order.getState()
        );

        return orderResponseDto; //주문에 대한 정보를 클라이언트에게 반환
    }
}
