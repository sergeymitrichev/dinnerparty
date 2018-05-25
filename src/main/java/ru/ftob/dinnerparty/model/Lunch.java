package ru.ftob.dinnerparty.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "lunches", uniqueConstraints = {@UniqueConstraint(columnNames = "date", name = "lunches_unique_restaurant_date_idx")})
public class Lunch extends AbstractBaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    @OneToMany(mappedBy = "lunch", fetch = FetchType.EAGER)
    private Set<Restaurant> restaurants;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "lunch_votes", joinColumns = {
            @JoinColumn(name = "lunch_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "user_id",
                    nullable = false, updatable = false) })
    private Set<User> votes;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled;

    public Lunch() {
    }

    public Lunch(Integer id, @NotNull LocalDate date) {
        super(id);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Set<User> getVotes() {
        return votes;
    }

    public void setVotes(Set<User> votes) {
        this.votes = votes;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Lunch{" +
                "date=" + date +
                ", enabled=" + enabled +
                ", id=" + id +
                '}';
    }
}
