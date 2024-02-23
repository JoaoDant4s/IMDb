package service;

import model.Actor;
import model.Director;
import model.Movie;
import repository.MovieRepository;
import service.exception.InvalidModelException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MovieService extends AbstractValidateService{
    MovieRepository movieRepository;

    public MovieService(){
        this.movieRepository = new MovieRepository();
    }

    private void validateMovie(String name, String releaseString, BigDecimal budget, String description, List<Actor> actors, Director director){
        validate(name, releaseString, "Filme");
        if(description.trim().isEmpty() || actors == null || director == null || budget == null){
            throw new InvalidModelException("Informações nulas passadas");
        }
        if(budget.floatValue() <= 0){
            throw new InvalidModelException("O custo total é menor que zero");
        }
    }


    public Movie createMovie(String name, String releaseString, BigDecimal budget, String description, List<Actor> actors, Director director){
        try{
            validateMovie(name, releaseString, budget, description, actors, director);
        } catch(RuntimeException exception){
            throw exception;
        }
        LocalDate release = convertDate(releaseString);
        if(release == null) return null;
        Movie movie = new Movie(name, release, budget, description, director);
        for (Actor actor : actors){
            movie.addActors(actor);
        }
        movieRepository.saveMovie(movie);
        return movie;
    }

    public List<Movie> listAllMovies(){
        return movieRepository.getAllMovies();
    }
}
