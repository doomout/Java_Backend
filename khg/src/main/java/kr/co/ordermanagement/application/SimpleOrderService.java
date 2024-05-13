package kr.co.ordermanagement.application;

import kr.co.ordermanagement.domain.order.OrderRepository;
import kr.co.ordermanagement.domain.product.ProductRepository;
import kr.co.ordermanagement.presentation.dto.OrderProductRequestDto;
import kr.co.ordermanagement.presentation.dto.OrderResponseDto;
import kr.co.ordermanagement.domain.order.Order;
import kr.co.ordermanagement.domain.product.Product;

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

    public OrderResponseDto createOrder(List<OrderProductRequestDto> orderProductRequestDtos) {
        List<Product> orderedProducts = makeOrderedProducts(orderProductRequestDtos);
        decreaseProductsAmount(orderedProducts);

        Order order = new Order(orderedProducts);
        orderRepository.add(order);

        OrderResponseDto orderResponseDto = OrderResponseDto.toDto(order);
        return orderResponseDto;
    }

    //상품 번호(id)에 해당하는 상품이 주문 수량 만큼 재고가 있는지 확인
    private List<Product> makeOrderedProducts(List<OrderProductRequestDto> orderProductRequestDtos) {
        return orderProductRequestDtos
                .stream()
                .map(orderProductRequestDto -> {
                    Long productId = orderProductRequestDto.getId();
                    Product product = productRepository.findById(productId);

                    Integer orderedAmount = orderProductRequestDto.getAmount();
                    product.checkEnoughAmount(orderedAmount); //주문 하려는 수량보다 상품 재고가 부족하면 예외를 던짐

                    return new Product(
                            productId,
                            product.getName(),
                            product.getPrice(),
                            orderProductRequestDto.getAmount()
                    );
                }).toList();
    }

    private void decreaseProductsAmount(List<Product> orderedProducts) {
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
