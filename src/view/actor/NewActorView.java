package view.actor;

import model.Actor;
import service.ActorService;
import service.exception.ServiceException;
import service.exception.ServiceRuntimeException;
import view.components.Input;
import view.movie.ListMoviesView;
import view.util.TerminalLettersColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewActorView{
    private final ActorService actorService;
    private final ListActorsView listActorsView;
    private final ListMoviesView listMoviesView;
    private final Scanner scan;

    public NewActorView(){
        this.actorService = new ActorService();
        this.scan = Input.getInstance();
        this.listActorsView = new ListActorsView();
        this.listMoviesView = new ListMoviesView();
    }

    public Actor createActor(Integer index){
        if(index != null){
            System.out.print("Digite o nome do " + index + "° ator: ");
        } else {
            System.out.print("Digite o nome do ator: ");
        }
        String name = scan.nextLine();
        System.out.print("Digite a data de nascimento do ator (DD/MM/AAAA): ");
        String birthString = scan.nextLine();
        Actor actor = null;
        try{
            actor = actorService.actorToBeCreated(name, birthString);
        } catch(ServiceRuntimeException exception) {
            System.err.println(exception.getMessage());
        }
        return actor;
    }

    public List<Actor> createListOfActors(){
        System.out.println("----Vamos começar cadastrando os atores do filme----");
        List<Actor> actorsToBeCreated = new ArrayList<>();
        for(Integer i = 1; true;){
            Actor actor = createActor(i);
            if(actor != null){
                i++;
                actorsToBeCreated.add(actor);
                System.out.print("Deseja adicionar outro ator (s/n)? ");
                Character choice = scan.nextLine().toLowerCase().charAt(0);
                if(choice == 'n') break;
            } else {
                try{
                    Thread.sleep(200);
                } catch(InterruptedException ignored){}
            }
        }try{
            actorService.createActors(actorsToBeCreated);
        } catch( ServiceException exception){
            System.err.println(exception.getMessage());
        }
        return actorsToBeCreated;
    }

    public void associateActor(){
        listActorsView.listActors();
        System.out.print("Digite o ID do ator para adicionar a um filme: ");
        Long actorId = scan.nextLong();
        listMoviesView.printIdAndMovieName();
        System.out.print("Digite o ID do filme para adicionar ao ator: ");
        Long movieId = scan.nextLong();
        try{
            actorService.associateActorAndMovie(actorId, movieId);
            System.out.println(TerminalLettersColor.greenOpen + "Ator adicionado com sucesso" + TerminalLettersColor.greenClose);
        } catch(ServiceException exception){
            System.err.println(exception.getMessage());
        }
    }

    public void newActor(){
        Actor actor = createActor(null);
        if(actor != null){
            try{
                actorService.createActors(List.of(actor));
                System.out.println(TerminalLettersColor.greenOpen + "Ator criado com sucesso" + TerminalLettersColor.greenClose);
            } catch(ServiceException exception){
                System.err.println(exception.getMessage());
            }
        }
    }
}
