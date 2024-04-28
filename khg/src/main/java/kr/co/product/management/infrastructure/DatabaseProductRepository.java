package kr.co.product.management.infrastructure;

import kr.co.product.management.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class DatabaseProductRepository {
    public Product add(Product product) {
        return null;
    }

    public Product findById(Long id) {
        return null;
    }

    public List<Product> findAll() {
        return Collections.EMPTY_LIST;
    }

    public List<Product> findByNameContaining(String name) {
        return Collections.EMPTY_LIST;
    }

    public Product update(Product product) {
        return null;
    }

    public void delete(Long id) {

    }
}
