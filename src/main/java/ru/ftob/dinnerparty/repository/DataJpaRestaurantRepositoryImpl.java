package ru.ftob.dinnerparty.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.ftob.dinnerparty.model.Dish;
import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.model.Restaurant;

import java.util.List;
import java.util.Set;

@Repository
public class DataJpaRestaurantRepositoryImpl implements RestaurantRepository {

    private static final Sort SORT_NAME = new Sort(Sort.Direction.ASC, "name");

    private final CrudRestaurantRepository crudRepository;

    @Autowired
    public DataJpaRestaurantRepositoryImpl(CrudRestaurantRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return crudRepository.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public Restaurant get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Restaurant> getAll(Lunch lunch) {
        return crudRepository.findByLunch(lunch);
    }

}
