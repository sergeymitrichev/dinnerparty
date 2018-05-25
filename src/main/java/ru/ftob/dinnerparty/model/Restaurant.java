package ru.ftob.dinnerparty.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "lunch_id"}, name = "lunches_unique_restaurant_date_idx")})
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @NotNull
    @Size(max = 255)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Lunch lunch;

    @OneToMany(mappedBy = "restaurant",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Dish> dishes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "lunch_votes", joinColumns = {
            @JoinColumn(name = "restaurant_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "user_id",
                    nullable = false, updatable = false) })
    private Set<User> votes;

    public Restaurant() {
    }

    public Restaurant(Integer id, @NotBlank @NotNull @Size(max = 255) String name, Lunch lunch) {
        super(id);
        this.name = name;
        this.lunch = lunch;
    }

    public Restaurant(Integer id, @NotBlank @NotNull @Size(max = 255) String name, Lunch lunch, Set<Dish> dishes, Set<User> votes) {
        super(id);
        this.name = name;
        this.lunch = lunch;
        this.dishes = dishes;
        this.votes = votes;
    }

    public Restaurant(Restaurant r) {
        this(r.getId(), r.getName(), r.getLunch(), r.getDishes(), r.getVotes());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    public Set<User> getVotes() {
        return votes;
    }

    public void setVotes(Set<User> votes) {
        this.votes = votes;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
