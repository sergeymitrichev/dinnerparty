package ru.ftob.dinnerparty.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ftob.dinnerparty.model.Dish;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.util.List;

import static ru.ftob.dinnerparty.DishTestData.*;
import static ru.ftob.dinnerparty.RestaurantTestData.RESTAURANT5;

public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    private DishService service;

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
        Dish newDish = new Dish(null, 1, "potato", RESTAURANT5);
        Dish created = service.create(newDish);
        newDish.setId(created.getId());
        assertMatch(service.getAll(), DISH8, DISH6, newDish, DISH9, DISH7, DISH10);
    }

    @Test
    public void get() throws Exception {
        Dish dish = service.get(DISH7_ID);
        assertMatch(dish, DISH7);
    }

    @Test
    public void update() throws Exception {
        Dish updated = new Dish(DISH7);
        updated.setName("UpdatedName");
        service.update(updated);
        assertMatch(service.get(DISH7_ID), updated);
    }

    @Test
    public void delete() throws Exception {
        service.delete(DISH7_ID);
        assertMatch(service.getAll(), DISH8, DISH6, DISH9, DISH10);
    }

    @Test
    public void getAll() throws Exception {
        List<Dish> all = service.getAll();
        assertMatch(all, DISH8, DISH6, DISH9, DISH7, DISH10);
    }
}
