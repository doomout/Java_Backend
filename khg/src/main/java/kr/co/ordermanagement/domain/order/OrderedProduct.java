package kr.co.ordermanagement.domain.order;

// OrderedProduct 클래스는 주문된 제품을 나타내는 도메인 모델
// 도메인 모델은 비즈니스 로직을 포함하고, 시스템의 핵심 역할을 담당
// 주문된 제품의 식별자, 이름, 가격, 수량 등의 정보를 관리하고, 
// 필요에 따라 주문된 제품을 수정하거나 삭제하는 등의 동작을 수행
public class OrderedProduct {
    private Long id; //상품의 고유 식별자
    private String name; //상품의 이름
    private Integer price; //상품의 가격
    private Integer amount; //주문된 상품의 수량

    public OrderedProduct(Long id, String name, Integer price, Integer amount) {
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
}
