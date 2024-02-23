package service;

import model.Actor;
import repository.ActorRepository;

import java.time.LocalDate;
import java.util.List;

public class ActorService extends AbstractValidateService{
    private final ActorRepository actorRepository;

    public ActorService(){
        this.actorRepository = new ActorRepository();
    }

    public void createActors(List<Actor> actors){
        for(Actor actor : actors){
            actorRepository.saveActor(actor);
        }
    }

    public Actor actorToBeCreated(String name, String birthString){
        validate(name, birthString, "Ator");
        LocalDate birthDate = convertDate(birthString);
        return birthDate != null ? new Actor(name, birthDate) : null;
    }
}
