package ru.ftob.dinnerparty.model;

import java.util.List;

public class Restaurant extends AbstractBaseEntity {

    private List<Lunch> lunches;

    private String name;

    public List<Lunch> getLunches() {
        return lunches;
    }

    public void setLunches(List<Lunch> lunches) {
        this.lunches = lunches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
