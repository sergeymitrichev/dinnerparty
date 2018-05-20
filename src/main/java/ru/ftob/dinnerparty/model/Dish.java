package ru.ftob.dinnerparty.model;

public class Dish extends AbstractBaseEntity {

    private Integer price;

    private String name;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
