package kr.co.product.management.domain;

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
}
