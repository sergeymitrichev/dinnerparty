package ru.ftob.dinnerparty.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.ftob.dinnerparty.model.Dish;
import ru.ftob.dinnerparty.model.User;

import java.util.List;

@Repository
public class DataJpaDishRepositoryImpl implements DishRepository {

    private static final Sort SORT_NAME = new Sort(Sort.Direction.ASC, "name");

    private final CrudDishRepository crudRepository;

    @Autowired
    public DataJpaDishRepositoryImpl(CrudDishRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Dish save(Dish dish) {
        return crudRepository.save(dish);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public Dish get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dish> getAll() {
        return crudRepository.findAll(SORT_NAME);
    }

}
