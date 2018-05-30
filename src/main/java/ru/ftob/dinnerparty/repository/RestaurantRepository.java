package ru.ftob.dinnerparty.repository;

import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.model.Restaurant;

import java.util.Set;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);

    Set<Restaurant> getAll(Lunch lunch);
}
