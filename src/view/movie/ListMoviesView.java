package view.movie;

import model.Actor;
import model.Movie;
import service.MovieService;
import service.exception.ServiceException;
import util.DateConverter;
import view.components.Input;

import java.util.List;
import java.util.Scanner;

public class ListMoviesView {
    private final MovieService movieService;
    private final Scanner scan;

    public ListMoviesView(){
        this.movieService = new MovieService();
        this.scan = Input.getInstance();
    }

    public void findMovie(){
        System.out.print("Digite o nome do filme: ");
        String movieName = scan.nextLine();
        try{
            List<Movie> movies = movieService.findMoviesByName(movieName);
            printMovies(movies);
        } catch (ServiceException e){
            System.out.println();
            findMovie();
        }
    }

    public void printMovies(List<Movie> movies){
        for (Movie movie : movies){
            System.out.println(movie.getId() + " - " + movie.getName());
            System.out.println("★ " + movie.getDirector().getName() + " - " + DateConverter.calculateAge(movie.getDirector().getBirthDate())  + " anos");
            for(Actor actor : movie.getActors()){
                System.out.println("◉ " + actor.getName() + " - " + DateConverter.calculateAge(actor.getBirthDate()) + " anos");
            }
        }
        System.out.println();
    }

    public void listMovies(){
        List<Movie> movies = movieService.listAllMovies();
        printMovies(movies);
    }
}
