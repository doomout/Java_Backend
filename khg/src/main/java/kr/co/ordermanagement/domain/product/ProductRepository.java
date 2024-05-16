package kr.co.ordermanagement.domain.product;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id); // 제품 ID로 조회
    List<Product> findAll();  // 모든 제품 조회
    void update(Product product); // 제품 업데이트
}
