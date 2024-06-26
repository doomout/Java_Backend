package kr.co.ordermanagement.application;

import kr.co.ordermanagement.domain.order.OrderRepository;
import kr.co.ordermanagement.domain.order.OrderedProduct;
import kr.co.ordermanagement.domain.product.ProductRepository;
import kr.co.ordermanagement.presentation.dto.ChangeStateRequestDto;
import kr.co.ordermanagement.presentation.dto.OrderProductRequestDto;
import kr.co.ordermanagement.presentation.dto.OrderResponseDto;
import kr.co.ordermanagement.domain.order.Order;
import kr.co.ordermanagement.domain.product.Product;
import kr.co.ordermanagement.domain.order.State;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleOrderService {
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    @Autowired
    public SimpleOrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    //주문 생성 
    public OrderResponseDto createOrder(List<OrderProductRequestDto> orderProductRequestDtos) {
        List<OrderedProduct> orderedProducts = makeOrderedProducts(orderProductRequestDtos);
        decreaseProductsAmount(orderedProducts);

        Order order = new Order(orderedProducts);
        orderRepository.add(order);

        OrderResponseDto orderResponseDto = OrderResponseDto.toDto(order);
        return orderResponseDto;
    }

    //주문 번호로 조회 기능
    public OrderResponseDto findById(Long orderId) {
        Order order = orderRepository.findById(orderId);

        OrderResponseDto orderResponseDto = OrderResponseDto.toDto(order);
        return orderResponseDto;
    }

    //주문 상태 변경 기능
    public OrderResponseDto changeState(Long orderId, ChangeStateRequestDto changeStateRequestDto) {
        Order order = orderRepository.findById(orderId);
        State state = changeStateRequestDto.getState();

        order.changeStateForce(state);

        OrderResponseDto orderResponseDto = OrderResponseDto.toDto(order);
        return orderResponseDto;
    }

    //주문 상태로 조회 기능
    public List<OrderResponseDto> findByState(State state) {
        List<Order> orders = orderRepository.findByState(state);

        List<OrderResponseDto> orderResponseDtos = orders
                .stream()
                .map(order -> OrderResponseDto.toDto(order))
                .toList();

        return orderResponseDtos;
    }

    //id로 주문 취소 기능
    public OrderResponseDto cancelOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId);

        order.cancel();

        OrderResponseDto orderResponseDto = OrderResponseDto.toDto(order);
        return orderResponseDto;
    }

    //상품 번호(id)에 해당하는 상품이 주문 수량 만큼 재고가 있는지 확인
    private List<OrderedProduct> makeOrderedProducts(List<OrderProductRequestDto> orderProductRequestDtos) {
        return orderProductRequestDtos
                .stream()
                .map(orderProductRequestDto -> {
                    Long productId = orderProductRequestDto.getId();
                    Product product = productRepository.findById(productId);

                    Integer orderedAmount = orderProductRequestDto.getAmount();
                    product.checkEnoughAmount(orderedAmount); //주문 하려는 수량보다 상품 재고가 부족하면 예외를 던짐

                    return new OrderedProduct(
                            productId,
                            product.getName(),
                            product.getPrice(),
                            orderProductRequestDto.getAmount()
                    );
                }).toList();
    }

    //차감된 상품 가격
    private void decreaseProductsAmount(List<OrderedProduct> orderedProducts) {
        orderedProducts
                .stream()
                .forEach(orderedProduct -> {
                    Long productId = orderedProduct.getId();
                    Product product = productRepository.findById(productId);

                    Integer orderedAmount = orderedProduct.getAmount();
                    product.decreaseAmount(orderedAmount);

                    productRepository.update(product);
                });
    }
}
