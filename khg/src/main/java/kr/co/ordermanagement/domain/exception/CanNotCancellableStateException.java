package kr.co.ordermanagement.domain.exception;

//주문을 취소할 수 없는 상태에서 주문을 취소하려고 할 때 발생
public class CanNotCancellableStateException extends RuntimeException {
    public CanNotCancellableStateException(String message) {
        super(message);
    }
}
