package kr.co.ordermanagement.domain.order;

import java.util.List;

public interface OrderRepository {
    Order add(Order order); // 주문 추가
    Order findById(Long id);  // 주문 ID로 조회
    List<Order> findByState(State state); // 주문 상태로 조회
}
