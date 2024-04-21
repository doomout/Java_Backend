package kr.co.product.management.domain;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Product {
    private Long id;

    @Size(min = 1, max = 100)
    private String name;

    @Max(1_000_000)
    @Min(0)
    private Integer price;

    @Max(9_999)
    @Min(0)
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
