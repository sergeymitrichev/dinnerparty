package ru.ftob.dinnerparty.service;

import ru.ftob.dinnerparty.model.Restaurant;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.util.List;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);

    void delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    void update(Restaurant restaurant);

    List<Restaurant> getAll();

}
