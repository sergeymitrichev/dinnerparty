package ru.ftob.dinnerparty.model;

import java.time.LocalDate;
import java.util.Set;

public class Lunch extends AbstractBaseEntity {

    private LocalDate date;

    private Restaurant restaurant;

    private Set<Dish> dishes;

    private Integer votes;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public boolean canVote() {
        return true;
    }
}
