package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Director extends Person{
    private final List<Long> participatedMoviesId;
    public Director(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.participatedMoviesId = new ArrayList<>();
    }

    public List<Long> getParticipatedMovies() {
        return Collections.unmodifiableList(participatedMoviesId);
    }

    public void addParticipatedMovie(Long participatedMovieId) {
        this.participatedMoviesId.add(participatedMovieId);
    }
}
