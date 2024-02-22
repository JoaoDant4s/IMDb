package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Actor extends Person{
    private final List<Long> participatedMoviesId;

    public Actor(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.participatedMoviesId = new ArrayList<>();
    }

    public List<Long> getParticipatedMovies() {
        return Collections.unmodifiableList(participatedMoviesId);
    }

    public void addParticipatedMovie(Long participatedMoviesId) {
        this.participatedMoviesId.add(participatedMoviesId);
    }
}
