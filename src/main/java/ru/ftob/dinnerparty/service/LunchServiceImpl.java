package ru.ftob.dinnerparty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.model.Restaurant;
import ru.ftob.dinnerparty.model.User;
import ru.ftob.dinnerparty.repository.DishRepository;
import ru.ftob.dinnerparty.repository.LunchRepository;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static ru.ftob.dinnerparty.util.ValidationUtil.checkNotFound;
import static ru.ftob.dinnerparty.util.ValidationUtil.checkNotFoundWithId;

public class LunchServiceImpl implements LunchService {

    private final LunchRepository repository;

    @Autowired
    public LunchServiceImpl(LunchRepository repository) {
        this.repository = repository;
    }

    @Override
    public Lunch create(Lunch lunch) {
        Assert.notNull(lunch, "lunch must not be null");
        return repository.save(lunch);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Lunch get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void update(Lunch lunch) {
        Assert.notNull(lunch, "lunch must not be null");
        checkNotFoundWithId(repository.save(lunch), lunch.getId());
    }

    @Override
    public List<Lunch> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Lunch> getByDate(LocalDate date) {
        return repository.getByDate(date);
    }

    @Override
    public Lunch gitWithVotes(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.gitWithVotes(id), id);
    }

    @Override
    public Lunch gitWithDishes(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.gitWithDishes(id), id);
    }

    @Override
    public void vote(Lunch lunch, User user, Restaurant restaurant) throws NotFoundException {
        checkNotFound(lunch.isEnabled(), "voting time is out");

        lunch.getVotes().remove(user);
        restaurant.getVotes().add(user);

        repository.vote(lunch, user, restaurant);
    }
}
