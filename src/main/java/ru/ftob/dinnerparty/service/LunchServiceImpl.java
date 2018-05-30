package ru.ftob.dinnerparty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.repository.LunchRepository;
import ru.ftob.dinnerparty.util.exception.NotFoundException;

import java.util.List;

import static ru.ftob.dinnerparty.util.ValidationUtil.checkNotFoundWithId;

@Service
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

}
