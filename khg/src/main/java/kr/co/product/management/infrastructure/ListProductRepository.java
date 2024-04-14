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
}
