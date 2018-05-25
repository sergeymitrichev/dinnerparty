package ru.ftob.dinnerparty.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "restaurant_id"}, name = "dishes_unique_name_restaurant_idx")})
public class Dish extends AbstractBaseEntity {

    @Column(name = "price", nullable = false)
    @NotNull
    private Integer price;

    @Column(name = "name", nullable = false)
    @NotBlank
    @NotNull
    @Size(max = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, @NotNull Integer price, @NotBlank @NotNull @Size(max = 255) String name, @NotNull Restaurant restaurant) {
        super(id);
        this.price = price;
        this.name = name;
        this.restaurant = restaurant;
    }

    public Dish(Dish d) {
        this(d.getId(), d.getPrice(), d.getName(), d.getRestaurant());
    }

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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
