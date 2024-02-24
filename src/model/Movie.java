package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movie extends UniqueId {
    private final String name;
    private final LocalDate release;
    private final BigDecimal budget;
    private String description;
    private Director director;
    private final List<Actor> actors;

    public Movie(String name, LocalDate release, BigDecimal budget, String description, Director director) {
        super();
        this.name = name;
        this.release = release;
        this.budget = budget;
        this.description = description;
        this.director = director;
        this.actors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getRelease() {
        return release;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director){ this.director = director;}

    public List<Actor> getActors() {
        return Collections.unmodifiableList(actors);
    }

    public void addActors(Actor actor) {
        this.actors.add(actor);
    }
}
