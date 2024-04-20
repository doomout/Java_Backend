package kr.co.product.management.domain;

import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public void setId(Long id) {
        this.id = id;
    }
    //받은 id와 인스턴스의 id를 비교하여 반환
    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }
    //매개변수로 받은 문자열이 상품 이름을 가지는 경우 참을 반환한다.
    public Boolean containsName(String name) {
        return this.name.contains(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if (o == null || getClass() != o.getClass()) 
            return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }
}
