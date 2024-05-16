package kr.co.ordermanagement.infrastructure;

import kr.co.ordermanagement.domain.exception.EntityNotFoundException;
import kr.co.ordermanagement.domain.product.Product;
import kr.co.ordermanagement.domain.product.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jakarta.annotation.PostConstruct;

@Repository
public class ListProductRepository implements ProductRepository { //ProductRepository 인터페이스를 구현하며, 메모리 내의 목록을 사용하여 제품 데이터를 관리
    private List<Product> products = new CopyOnWriteArrayList<>(); //제품 목록을 저장

    @PostConstruct
    void initProducts() {  //초기 제품 데이터를 생성하여 목록에 추가
        Product product1 = new Product(1L, "상품1", 10000, 100);
        Product product2 = new Product(2L, "상품2", 25000, 300);
        Product product3 = new Product(3L, "상품3", 30000, 500);

        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    @Override
    public Product findById(Long id) { //주어진 ID에 해당하는 제품을 찾기
        return products.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product를 찾지 못했습니다.")); //제품을 찾을 수 없는 경우 
    }

    @Override
    public List<Product> findAll() { //모든 제품 목록을 반환
        return products;
    }

    @Override
    public void update(Product product) {  // 주어진 제품 정보로 해당 제품을 업데이트
        Integer indexToModify = products.indexOf(product);
        products.set(indexToModify, product);
    }
}
