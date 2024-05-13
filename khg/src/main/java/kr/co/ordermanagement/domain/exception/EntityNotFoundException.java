package kr.co.ordermanagement.domain.exception;

//엔티티를 찾이 못했을 때 발생하는 에외
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
