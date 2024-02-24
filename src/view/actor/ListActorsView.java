package view.actor;

import model.Actor;
import service.ActorService;
import view.util.TerminalLettersColor;

import java.util.List;

public class ListActorsView {
    private final ActorService actorService;

    public ListActorsView(){
        this.actorService = new ActorService();
    }
    public void printActors(List<Actor> actors){
        if(actors.isEmpty()){
            System.out.println(TerminalLettersColor.yellowOpen + "--Nenhum ator encontrado--" + TerminalLettersColor.yellowClose);
        }
        System.out.println("Id | Nome");
        for (Actor actor : actors){
            System.out.println(actor.getId() + "  " + actor.getName());
        }
    }
    public void listActors(){
        List<Actor> actors = actorService.listAllActors();
        printActors(actors);
    }
}
