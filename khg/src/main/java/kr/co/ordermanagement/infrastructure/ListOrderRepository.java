package kr.co.ordermanagement.infrastructure;

import kr.co.ordermanagement.domain.exception.EntityNotFoundException;
import kr.co.ordermanagement.domain.order.Order;
import kr.co.ordermanagement.domain.order.OrderRepository;
import kr.co.ordermanagement.domain.order.State;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;


@Repository
public class ListOrderRepository implements OrderRepository {
    private List<Order> orders = new CopyOnWriteArrayList<>();
    private AtomicLong sequence = new AtomicLong(1L);

    @Override
    public Order add(Order order) { //새로운 주문을 추가
        order.setId(sequence.getAndAdd(1L));

        orders.add(order);
        return order;
    }

    @Override
    public Order findById(Long id) { //주어진 ID에 해당하는 주문을 찾기
        return orders.stream()
                .filter(order -> order.sameId(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Order를 찾지 못했습니다.")); //주문을 찾을 수 없는 경우
    }

    @Override
    public List<Order> findByState(State state) { //주어진 상태에 해당하는 주문 목록을 반환
        return orders.stream()
                .filter(order -> order.sameState(state))
                .toList();
    }

}
