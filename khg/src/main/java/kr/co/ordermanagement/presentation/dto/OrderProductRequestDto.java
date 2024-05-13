package kr.co.ordermanagement.presentation.dto;

//주문 요청 처리 DTO
public class OrderProductRequestDto {
    private Long id; //주문 상품 번호
    private Integer amount; //주문 수량

    public Long getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }
}
