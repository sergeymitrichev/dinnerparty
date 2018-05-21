package ru.ftob.dinnerparty.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.ftob.dinnerparty.model.User;

import java.util.List;

@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {

    private static final Sort SORT_NAME_EMAIL = new Sort(Sort.Direction.ASC, "email");

    private final CrudUserRepository crudRepository;

    @Autowired
    public DataJpaUserRepositoryImpl(CrudUserRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public User save(User user) {
        return crudRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }

}
