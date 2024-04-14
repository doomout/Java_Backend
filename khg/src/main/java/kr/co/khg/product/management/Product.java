package kr.co.khg.product.management;

public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getAmount() {
        return this.amount;
    }
}
