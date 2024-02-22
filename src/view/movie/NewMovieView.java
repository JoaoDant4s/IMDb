package view.movie;

import model.Actor;
import service.MovieService;
import view.actor.NewActorView;
import view.components.Input;
import view.director.NewDirectorView;

import java.util.List;
import java.util.Scanner;

public class NewMovieView{
    private MovieService movieService;
    private final NewActorView newActorView;
    private final NewDirectorView newDirectorView;
    private Scanner scan;

    public NewMovieView(){
        this.movieService = new MovieService();
        this.scan = Input.getInstance();
        this.newActorView = new NewActorView();
        this.newDirectorView = new NewDirectorView();
    }

    public void execute(){
        List<Actor> actors = newActorView.createListOfActors();
        System.out.println("Atores criados com sucesso");
        for(Actor actor : actors){
            System.out.println(actor.getName());
        }
//        Director director = newDirectorView.createDirector();
    }
}

