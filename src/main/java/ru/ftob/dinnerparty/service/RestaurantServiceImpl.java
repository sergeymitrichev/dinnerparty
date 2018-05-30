package ru.ftob.dinnerparty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.ftob.dinnerparty.model.Dish;
import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.model.Restaurant;
import ru.ftob.dinnerparty.model.User;
import ru.ftob.dinnerparty.repository.DishRepository;
import ru.ftob.dinnerparty.repository.RestaurantRepository;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static ru.ftob.dinnerparty.util.ValidationUtil.checkNotFound;
import static ru.ftob.dinnerparty.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "dish must not be null");
        return repository.save(restaurant);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNotFoundWithId(repository.save(restaurant), restaurant.getId());
    }

    @Override
    public Set<Restaurant> getAll(Lunch lunch) {
        return repository.getAll(lunch);
    }

    @Override
    @Transactional
    public void vote(User user, int id) {
        Restaurant restaurant = get(id);
        Lunch lunch = restaurant.getLunch();
        checkNotFound(lunch.isEnabled(), "voting time is out");
        Set<Restaurant> restaurants = getAll(lunch);

        //restaurants.stream().forEach((r) -> r.getVotes().remove(user));

        Iterator<Restaurant> iterator = restaurants.iterator();
        while (iterator.hasNext()) {
            Restaurant r = iterator.next();
            if (!r.getVotes().contains(user)) {
                continue;
            }
            r.getVotes().remove(user);
            update(r);
            break;
        }
        restaurant.getVotes().add(user);
        update(restaurant);
    }

}
