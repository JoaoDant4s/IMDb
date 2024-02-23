package view.movie;

import model.Actor;
import model.Director;
import model.Movie;
import service.MovieService;
import service.exception.ServiceException;
import view.util.TerminalLettersColor;
import view.actor.NewActorView;
import view.components.Input;
import view.director.NewDirectorView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class NewMovieView{
    private final MovieService movieService;
    private final NewActorView newActorView;
    private final NewDirectorView newDirectorView;
    private final Scanner scan;

    public NewMovieView(){
        this.movieService = new MovieService();
        this.scan = Input.getInstance();
        this.newActorView = new NewActorView();
        this.newDirectorView = new NewDirectorView();
    }
    private Movie createMovie(List<Actor> actors, Director director){
        System.out.println("----Informações do filme----");
        System.out.print("Nome do filme: ");
        String name = scan.nextLine();
        System.out.print("Data de lançamento: ");
        String releaseString = scan.nextLine();
        System.out.print("Custo total: ");
        BigDecimal budget = new BigDecimal(scan.nextLine());
        System.out.print("Descrição: ");
        String description = scan.nextLine();
        Movie movie = null;
        try{
            movie = movieService.createMovie(name, releaseString, budget, description, actors, director);
        } catch(ServiceException exception) {
            System.err.println(exception.getMessage());
        }
        return movie;
    }

    public void execute(){
        List<Actor> actors = newActorView.createListOfActors();
        System.out.println(TerminalLettersColor.greenOpen + "Atores criados com sucesso" + TerminalLettersColor.greenClose);
        Director director = newDirectorView.createDirector();
        System.out.println(TerminalLettersColor.greenOpen + "Diretor criado com sucesso" + TerminalLettersColor.greenClose);
        Movie movie = createMovie(actors, director);
        System.out.println(TerminalLettersColor.greenOpen + "Filme \"" + movie.getName() + "\" criado com sucesso" + TerminalLettersColor.greenClose);
    }
}

