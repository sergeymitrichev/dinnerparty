package ru.ftob.dinnerparty.service;

import ru.ftob.dinnerparty.exception.NotFoundException;
import ru.ftob.dinnerparty.model.Dish;

import java.util.List;

public interface DishService {

    Dish create(Dish dish);

    void delete(int id) throws NotFoundException;

    Dish get(int id) throws NotFoundException;

    void update(Dish dish);

    List<Dish> getAll(Integer lunchId);

}
