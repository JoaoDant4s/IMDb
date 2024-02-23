package view.actor;

import model.Actor;
import service.ActorService;
import service.exception.ServiceException;
import view.components.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewActorView{
    private final ActorService actorService;
    private final Scanner scan;

    public NewActorView(){
        this.actorService = new ActorService();
        this.scan = Input.getInstance();
    }

    private Actor createActor(Integer index){
        System.out.print("Digite o nome do " + index + "° ator: ");
        String name = scan.nextLine();
        System.out.print("Digite a data de nascimento do ator (DD/MM/AAAA): ");
        String birthString = scan.nextLine();
        Actor actor = null;
        try{
            actor = actorService.actorToBeCreated(name, birthString);
        } catch(ServiceException exception) {
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
        }
        actorService.createActors(actorsToBeCreated);
        return actorsToBeCreated;
    }
}
