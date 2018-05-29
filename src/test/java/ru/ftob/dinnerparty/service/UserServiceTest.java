package ru.ftob.dinnerparty.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ftob.dinnerparty.model.User;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.util.List;

import static ru.ftob.dinnerparty.UserTestData.*;
import static ru.ftob.dinnerparty.model.Role.ROLE_USER;

public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService service;

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
        User newUser = new User(null, "newuser@mail.ru", "password", ROLE_USER);
        User created = service.create(newUser);
        newUser.setId(created.getId());
        assertMatch(service.getAll(), ADMIN, newUser, USER);
    }

    @Test
    public void get() throws Exception {
        User user = service.get(USER_ID);
        assertMatch(user, USER);
    }

    @Test
    public void update() throws Exception {
        User updated = new User(USER);
        updated.setPassword("UpdatedPassword");
        service.update(updated);
        assertMatch(service.get(USER_ID), updated);
    }

    @Test
    public void delete() throws Exception {
        service.delete(USER_ID);
        assertMatch(service.getAll(), ADMIN);
    }

    @Test
    public void getAll() throws Exception {
        List<User> all = service.getAll();
        assertMatch(all, ADMIN, USER);
    }
}
