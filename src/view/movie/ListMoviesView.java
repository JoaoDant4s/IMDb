package view.movie;

import model.Actor;
import model.Movie;
import service.MovieService;

import java.util.List;

public class ListMoviesView {
    private final MovieService movieService;

    public ListMoviesView(){
        this.movieService = new MovieService();
    }

    public void execute(){
        List<Movie> movies = movieService.listAllMovies();
        for (Movie movie : movies){
            System.out.println(movie.getId() + " - " + movie.getName());
            for(Actor actor : movie.getActors()){
                System.out.println(actor.getName() + actor.getBirthDate());
            }
        }
    }
}
