package ru.ftob.dinnerparty.repository;

import ru.ftob.dinnerparty.model.Dish;

import java.util.List;

public interface DishRepository {

    Dish save(Dish dish);

    boolean delete(int id);

    Dish get(int id);

    List<Dish> getAll();

}
