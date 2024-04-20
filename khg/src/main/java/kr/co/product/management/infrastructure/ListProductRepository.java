package kr.co.product.management.infrastructure;

import kr.co.product.management.domain.Product;
import org.springframework.stereotype.Repository;
import java.util.concurrent.CopyOnWriteArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository //빈으로 등록
public class ListProductRepository {
    private List<Product> products = new CopyOnWriteArrayList<>();
    private AtomicLong sequence = new AtomicLong(1L);

    public Product add(Product product) {
        product.setId(sequence.getAndAdd(1L));
        
        products.add(product);
        return product;
    }

    public Product findById(Long id) {
        return products.stream()
                        .filter(product -> product.sameId(id))
                        .findFirst() //첫 번째 Product 반환
                        .orElseThrow();  // 비어 있으면 예외 반환, 있으면 Product 값 반환
    }

    //전체 상품 목록 조회 
    public List<Product> findAll() {
        return products;
    }

    public List<Product> findByNameContaining(String name) {
        return products.stream()
                .filter(product -> product.containsName(name))
                .toList(); //여러 결과가 나올 것이기에 리스트를 반환한다.
    }

    //Product 를 통째로 바꿔버리는 부분
    public Product update(Product product) {
        Integer indexToModify = products.indexOf(product);
        products.set(indexToModify, product);
        return product;
    }
}
