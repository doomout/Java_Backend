package kr.co.ordermanagement.domain.exception;

//주문 수량이 재고 수량보다 많은 경우
public class NotEnoughAmountException extends RuntimeException {
    public NotEnoughAmountException(String message) {
        super(message);
    }
}
