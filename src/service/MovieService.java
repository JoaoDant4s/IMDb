package service;

import repository.MovieRepository;

public class MovieService {
    MovieRepository movieRepository;

    public MovieService(){
        this.movieRepository = new MovieRepository();
    }

    public void newMovie(){

    }
}
