package ru.ftob.dinnerparty.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ftob.dinnerparty.model.Restaurant;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.util.List;

import static ru.ftob.dinnerparty.LunchTestData.LUNCH3;
import static ru.ftob.dinnerparty.RestaurantTestData.*;

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
        Restaurant newRestaurant = new Restaurant(null, "Capital", LUNCH3);
        Restaurant created = service.create(newRestaurant);
        newRestaurant.setId(created.getId());
        assertMatch(service.getAll(), newRestaurant, RESTAURANT4, RESTAURANT5);
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
        assertMatch(service.getAll(), RESTAURANT5);
    }

    @Test
    public void getAll() throws Exception {
        List<Restaurant> all = service.getAll();
        assertMatch(all, RESTAURANT4, RESTAURANT5);
    }
}
