package ru.ftob.dinnerparty.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.model.Restaurant;
import ru.ftob.dinnerparty.model.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaLunchRepositoryImpl implements LunchRepository {

    private static final Sort SORT_DATE = new Sort(Sort.Direction.ASC, "date");

    private final CrudLunchRepository crudLunchRepository;

    private final CrudRestaurantRepository crudRestaurantRepository;

    @Autowired
    public DataJpaLunchRepositoryImpl(CrudLunchRepository crudLunchRepository, CrudRestaurantRepository crudRestaurantRepository) {
        this.crudLunchRepository = crudLunchRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    public Lunch save(Lunch lunch) {
        return crudLunchRepository.save(lunch);
    }

    @Override
    public boolean delete(int id) {
        return crudLunchRepository.delete(id) != 0;
    }

    @Override
    public boolean deleteAll(List<Lunch> lunches) {
        return true;
    }

    @Override
    public Lunch get(int id) {
        return crudLunchRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lunch> getAll() {
        return crudLunchRepository.findAll(SORT_DATE);
    }

    @Override
    public List<Lunch> getByDate(LocalDate date) {
        return crudLunchRepository.findByDate(date);
    }


    @Override
    public Lunch gitWithVotes(int id) {
        return crudLunchRepository.getWithVotes(id);
    }

    @Override
    public Lunch gitWithDishes(int id) {
        return crudLunchRepository.getWithDishes(id);
    }

    @Override
    public boolean vote(Lunch lunch, User user, Restaurant restaurant) {
        return crudLunchRepository.save(lunch) != null && crudRestaurantRepository.save(restaurant) != null;
    }
}
