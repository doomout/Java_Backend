package kr.co.ordermanagement.domain.order;

import java.util.List;

public class Order {
    private Long id; //주문의 고유 식별자
    private List<OrderedProduct> orderedProducts; //주문된 상품 목록
    private Integer totalPrice; //주문의 총 가격
    private State state; //주문 상태

    public Order(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
        this.totalPrice = calculateTotalPrice(orderedProducts);
        this.state = State.CREATED;
    }

    public Long getId() {
        return id;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public State getState() {
        return state;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }

    public Boolean sameState(State state) {
        return this.state.equals(state);
    }

    public void changeStateForce(State state) {
        this.state = state;
    }

    //주문을 취소하는데, 이 때 주문의 상태가 취소 가능한지 확인한 후 취소 상태로 변경
    public void cancel() {
        this.state.checkCancellable();
        this.state  = State.CANCELED;
    }

    //모든 주문된 상품의 가격을 합산하여 총 주문 가격을 계산  (상품 가격 * 수량) + 합
    private Integer calculateTotalPrice(List<OrderedProduct> orderedProducts) {
        return orderedProducts
                .stream()
                .mapToInt(orderedProduct -> orderedProduct.getPrice() * orderedProduct.getAmount())
                .sum();
    }
}
