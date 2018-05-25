package ru.ftob.dinnerparty.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ftob.dinnerparty.model.Lunch;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudLunchRepository extends JpaRepository<Lunch, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Lunch l WHERE l.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Lunch save(Lunch lunch);

    @Override
    Optional<Lunch> findById(Integer id);

    @Override
    List<Lunch> findAll(Sort sort);

    List<Lunch> findByDate(LocalDate date);

    @EntityGraph(attributePaths = {"lunch_votes"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT l FROM Lunch l WHERE l.id=?1")
    Lunch getWithVotes(int id);

    @EntityGraph(attributePaths = {"dishes"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT l FROM Lunch l WHERE l.id=?1")
    Lunch getWithDishes(int id);

}
