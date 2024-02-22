package service;

import model.Actor;
import repository.ActorRepository;
import service.exception.InvalidDatePatternException;
import service.exception.InvalidModelException;
import service.exception.ServiceException;
import util.DateConverter;

import java.time.LocalDate;
import java.util.List;

public class ActorService {
    private ActorRepository actorRepository;

    public ActorService(){
        this.actorRepository = new ActorRepository();
    }

    public void createActors(List<Actor> actors){
        for(Actor actor : actors){
            actorRepository.saveActor(actor);
        }
    }

    public Actor actorToBeCreated(String name, String birthString){
        Actor actorTobeCreated;
        if(name == null || birthString == null){
            throw new InvalidModelException("Ator informado com campo nulo");
        }
        try{
            LocalDate birthDate = DateConverter.formatDateStringByPattern(birthString, "dd/MM/yyyy");
            actorTobeCreated = new Actor(name, birthDate);
        } catch(InvalidDatePatternException exception){
            throw new ServiceException(exception.getMessage(), exception);
        }
        return actorTobeCreated;
    }
}
