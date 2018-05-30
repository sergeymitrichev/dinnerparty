package ru.ftob.dinnerparty.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.time.Month;
import java.util.List;

import static java.time.LocalDate.of;
import static ru.ftob.dinnerparty.LunchTestData.*;

public class LunchServiceTest extends AbstractServiceTest {

    @Autowired
    private LunchService service;

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
        Lunch newLunch = new Lunch(null, of(2018, Month.MAY, 31));
        Lunch created = service.create(newLunch);
        newLunch.setId(created.getId());
        assertMatch(service.getAll(), LUNCH2, newLunch, LUNCH3);
    }

    @Test
    public void get() throws Exception {
        Lunch lunch = service.get(LUNCH2_ID);
        assertMatch(lunch, LUNCH2);
    }

    @Test
    public void update() throws Exception {
        Lunch updated = new Lunch(LUNCH2);
        updated.setDate(of(2018, Month.MAY, 30));
        updated.setEnabled(false);
        service.update(updated);
        assertMatch(service.get(LUNCH2_ID), updated);
    }

    @Test
    public void delete() throws Exception {
        service.delete(LUNCH2_ID);
        assertMatch(service.getAll(), LUNCH3);
    }

    @Test
    public void getAll() throws Exception {
        List<Lunch> all = service.getAll();
        assertMatch(all, LUNCH2, LUNCH3);
    }
}
