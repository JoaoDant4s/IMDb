package view.movie;

import model.Actor;
import model.Movie;
import service.MovieService;
import service.exception.ServiceException;
import view.util.DateConverter;
import view.components.Input;
import view.util.TerminalLettersColor;

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
        if(movies.isEmpty()){
            System.out.println(TerminalLettersColor.yellowOpen + "--Nenhum filme encontrado--" + TerminalLettersColor.yellowClose);
        }
        for (Movie movie : movies){
            System.out.println(TerminalLettersColor.purpleBackgroundOpen + "--Filmes encontrados--" + TerminalLettersColor.purpleBackgroundClose );
            System.out.println(TerminalLettersColor.greenOpen + movie.getId() + " - " + movie.getName() + TerminalLettersColor.greenClose);
            System.out.println("★ " + movie.getDirector().getName() + " - " + DateConverter.calculateAge(movie.getDirector().getBirthDate())  + " anos");
            for(Actor actor : movie.getActors()){
                System.out.println("◉ " + actor.getName() + " - " + DateConverter.calculateAge(actor.getBirthDate()) + " anos");
            }
            System.out.println("Sobre: " + movie.getDescription());
            System.out.println("Data de lançamento: " + DateConverter.formatDateByPattern(movie.getRelease(), "dd/MM/yyyy"));
            System.out.println("Custo total: " + movie.getBudget());
        }
        System.out.println();
    }

    public void listMovies(){
        List<Movie> movies = movieService.listAllMovies();
        printMovies(movies);
    }
}
