package ru.ftob.dinnerparty.repository;

import ru.ftob.dinnerparty.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    List<User> getAll();

}
