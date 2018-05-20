package ru.ftob.dinnerparty.service;

import ru.ftob.dinnerparty.exception.NotFoundException;
import ru.ftob.dinnerparty.model.Lunch;

import java.time.LocalDate;
import java.util.List;

public interface LunchService {

    Lunch create(Lunch lunch);

    void delete(int id) throws NotFoundException;

    Lunch get(int id) throws NotFoundException;

    void update(Lunch lunch);

    List<Lunch> getAll(LocalDate date);

}
