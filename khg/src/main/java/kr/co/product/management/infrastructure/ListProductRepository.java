package kr.co.product.management.infrastructure;

import kr.co.product.management.domain.EntityNotFoundException;
import kr.co.product.management.domain.Product;
import kr.co.product.management.domain.ProductRepository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.concurrent.CopyOnWriteArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("test")
public class ListProductRepository implements ProductRepository {
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
                        .orElseThrow(() -> new EntityNotFoundException("Product를 찾지 못했습니다."));  // 에러 메시지 명시
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

    //Product 를 통째로 바꿔서 수정한다.
    public Product update(Product product) {
        Integer indexToModify = products.indexOf(product);
        products.set(indexToModify, product);
        return product;
    }

    //삭제
    public void delete(Long id) {
        Product product = this.findById(id);
        products.remove(product); //remove 는 equals 를 기준으로 동당한 요소를 찾아서 지워주는 기능을 한다.
    }

}
