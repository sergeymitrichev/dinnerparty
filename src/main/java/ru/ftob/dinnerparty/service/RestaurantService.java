package ru.ftob.dinnerparty.service;

import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.model.Restaurant;
import ru.ftob.dinnerparty.model.User;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.util.Set;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);

    void delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    void update(Restaurant restaurant);

    Set<Restaurant> getAll(Lunch lunch);

    void vote(User user, int id);

}
