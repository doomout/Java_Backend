package kr.co.ordermanagement.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ordermanagement.application.SimpleOrderService;
import kr.co.ordermanagement.domain.order.State;
import kr.co.ordermanagement.presentation.dto.OrderProductRequestDto;
import kr.co.ordermanagement.presentation.dto.OrderResponseDto;
import kr.co.ordermanagement.presentation.dto.ChangeStateRequestDto;

@RestController
public class OrderRestController {
    private SimpleOrderService simpleOrderService;

    @Autowired
    OrderRestController(SimpleOrderService simpleOrderService) {
        this.simpleOrderService = simpleOrderService;
    }

    // 상품 주문 API
    @RequestMapping(value = "/orders", method = RequestMethod.POST) //POST 메서드로 주문을 생성
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody List<OrderProductRequestDto> orderProductRequestDtos) {
        OrderResponseDto orderResponseDto = simpleOrderService.createOrder(orderProductRequestDtos);

        return ResponseEntity.ok(orderResponseDto);
    }

    // 주문번호로 조회 API
    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)  // GET 메서드로 주문을 주문 번호로 조회
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long orderId) {
        OrderResponseDto orderResponseDto = simpleOrderService.findById(orderId);

        return ResponseEntity.ok(orderResponseDto);
    }

    // 주문상태 강제 변경 API
    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.PATCH)  //PATCH 메서드로 주문의 상태를 변경
    public ResponseEntity<OrderResponseDto> changeOrderState(
            @PathVariable Long orderId,
            @RequestBody ChangeStateRequestDto changeStateRequestDto
    ) {
        OrderResponseDto orderResponseDto = simpleOrderService.changeState(orderId, changeStateRequestDto);

        return ResponseEntity.ok(orderResponseDto);
    }

    // 주문상태로 조회 API
    @RequestMapping(value = "/orders", method = RequestMethod.GET) //GET 메서드로 주문을 상태로 조회
    public ResponseEntity<List<OrderResponseDto>> getOrdersByState(@RequestParam State state) {
        List<OrderResponseDto> orderResponseDtos = simpleOrderService.findByState(state);

        return ResponseEntity.ok(orderResponseDtos);
    }

    // 주문 취소 API
    @RequestMapping(value = "/orders/{orderId}/cancel", method = RequestMethod.PATCH)  // PATCH 메서드로 주문을 취소
    public ResponseEntity<OrderResponseDto> cancelOrderById(@PathVariable Long orderId) {
        OrderResponseDto orderResponseDto = simpleOrderService.cancelOrderById(orderId);

        return ResponseEntity.ok(orderResponseDto);
    }
}
