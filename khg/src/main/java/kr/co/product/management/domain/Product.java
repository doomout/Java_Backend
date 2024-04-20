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
    //매개변수로 받은 문자열이 상품 이름을 가지는 경우 참을 반환한다.
    public Boolean containsName(String name) {
        return this.name.contains(name);
    }
}
