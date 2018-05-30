package ru.ftob.dinnerparty.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "lunches", uniqueConstraints = {@UniqueConstraint(columnNames = "date", name = "lunches_unique_restaurant_date_idx")})
public class Lunch extends AbstractBaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    @OneToMany(mappedBy = "lunch", fetch = FetchType.EAGER)
    private Set<Restaurant> restaurants;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    public Lunch() {
    }

    public Lunch(Integer id, @NotNull LocalDate date) {
        super(id);
        this.date = date;
    }

    public Lunch(Integer id, @NotNull LocalDate date, Set<Restaurant> restaurants, boolean enabled) {
        super(id);
        this.date = date;
        this.restaurants = restaurants;
        this.enabled = enabled;
    }

    public Lunch(Integer id, @NotNull LocalDate date, boolean enabled, Restaurant restaurant, Restaurant... restaurants) {
        super(id);
        this.date = date;
        this.enabled = enabled;
        this.restaurants.add(restaurant);
        Collections.addAll(this.restaurants, restaurants);
    }

    public Lunch(Lunch l) {
        this(l.getId(), l.getDate(), l.getRestaurants(), l.isEnabled());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Lunch{" +
                "date=" + date +
                ", enabled=" + enabled +
                ", id=" + id +
                '}';
    }
}
