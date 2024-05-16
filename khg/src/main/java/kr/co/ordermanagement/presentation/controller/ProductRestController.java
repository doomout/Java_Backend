package kr.co.ordermanagement.presentation.controller;

import java.util.List;

import kr.co.ordermanagement.application.SimpleProductService;
import kr.co.ordermanagement.presentation.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController { //제품 목록을 조회하는 엔드포인트를 정의
   private SimpleProductService simpleProductService;

    @Autowired
    ProductRestController(SimpleProductService simpleProductService) { 
        this.simpleProductService = simpleProductService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)  //GET 메서드로 모든 제품을 조회
    public List<ProductDto> findProducts() {
        return simpleProductService.findAll();
    } 
}
