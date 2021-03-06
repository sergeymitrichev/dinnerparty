package ru.ftob.dinnerparty.repository;

import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.model.Restaurant;
import ru.ftob.dinnerparty.model.User;

import java.time.LocalDate;
import java.util.List;

public interface LunchRepository {

    Lunch save(Lunch lunch);

    boolean delete(int id);

    boolean deleteAll(List<Lunch> lunches);

    Lunch get(int id);

    List<Lunch> getAll();
}
