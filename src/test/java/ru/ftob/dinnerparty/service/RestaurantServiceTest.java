package ru.ftob.dinnerparty.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ftob.dinnerparty.UserTestData;
import ru.ftob.dinnerparty.model.Restaurant;
import ru.ftob.dinnerparty.model.User;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.util.HashSet;
import java.util.Set;

import static ru.ftob.dinnerparty.LunchTestData.LUNCH2;
import static ru.ftob.dinnerparty.RestaurantTestData.*;
import static ru.ftob.dinnerparty.UserTestData.ADMIN;
import static ru.ftob.dinnerparty.UserTestData.USER;

public class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    private RestaurantService service;

    @Test
    public void deleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.delete(100);
    }

    @Test
    public void getNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.get(100);
    }

    @Test
    public void create() throws Exception {
        Restaurant newRestaurant = new Restaurant(null, "Capital", LUNCH2);
        Restaurant created = service.create(newRestaurant);
        newRestaurant.setId(created.getId());
        assertMatch(service.getAll(LUNCH2), RESTAURANT4, RESTAURANT5, newRestaurant);
    }

    @Test
    public void get() throws Exception {
        Restaurant restaurant = service.get(RESTAURANT4_ID);
        assertMatch(restaurant, RESTAURANT4);
    }

    @Test
    public void update() throws Exception {
        Restaurant updated = new Restaurant(RESTAURANT4);
        updated.setName("UpdatedName");
        service.update(updated);
        assertMatch(service.get(RESTAURANT4_ID), updated);
    }

    @Test
    public void delete() throws Exception {
        service.delete(RESTAURANT4_ID);
        assertMatch(service.getAll(LUNCH2), RESTAURANT5);
    }

    @Test
    public void getAll() throws Exception {
        Set<Restaurant> all = service.getAll(LUNCH2);
        assertMatch(all, RESTAURANT4, RESTAURANT5);
    }
    @Test
    public void vote() throws Exception {
        Set<User> votes = new HashSet();
        votes.add(USER);
        votes.add(ADMIN);
        RESTAURANT4.setVotes(votes);
        service.vote(USER, RESTAURANT5_ID);
        Restaurant voted = service.get(RESTAURANT5_ID);
        Restaurant revoked = service.get(RESTAURANT4_ID);

        UserTestData.assertMatch(voted.getVotes(), USER);
        UserTestData.assertMatch(revoked.getVotes(), ADMIN);

    }
}
