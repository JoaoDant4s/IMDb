package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Actor extends Person{
    private final List<Movie> participatedMovies;

    public Actor(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.participatedMovies = new ArrayList<>();
    }

    public List<Movie> getParticipatedMovies() {
        return Collections.unmodifiableList(participatedMovies);
    }

    public void addParticipatedMovie(Movie participatedMovies) {
        this.participatedMovies.add(participatedMovies);
    }
}
