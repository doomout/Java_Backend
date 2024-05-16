package kr.co.ordermanagement.domain.product;

import java.util.Objects;
import kr.co.ordermanagement.domain.exception.NotEnoughAmountException;

// Product 클래스는 도메인 모델로, 비즈니스 로직을 포함
// 예를 들어, 제품의 가격을 변경하거나 재고를 업데이트하는 등의 기능을 담당
// 도메인 모델은 엔티티의 상태와 행위를 나타내며, 비즈니스 규칙을 구현
public class Product {
    private Long id; //제품 고유 식별자
    private String name; //제품 이름
    private Integer price;  //제품 가격
    private Integer amount; //제품 재고 수량

    // 생성자를 통해 각 필드의 값을 초기화
    public Product(Long id, String name, Integer price, Integer amount) {
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

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }

    //재고 체크
    public void checkEnoughAmount(Integer orderedAmount) {
        if(this.amount < orderedAmount)
            throw new NotEnoughAmountException(this.id + "번 상품의 수량이 부족합니다.");
    }

    //상품을 가져와서 상품의 재고를 주문된 수량만큼 뺀다.
    public void decreaseAmount(Integer orderedAmount) {
        this.amount = this.amount - orderedAmount;
    }


    @Override
    public boolean equals(Object o) { //객체 간의 동등성 비교를 위해 equals 메서드를 오버라이드
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }
}
