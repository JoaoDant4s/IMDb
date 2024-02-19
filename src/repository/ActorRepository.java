package repository;

import model.Actor;
import persistance.Database;

import java.util.List;

public class ActorRepository {
    public Actor getActorById(Long id){
        Object obj = Database.getByClassAndId(Actor.class, id);
        return (Actor) obj;
    }

    public List<Actor> getAllActors(){
        return (List<Actor>) Database.getAllByClass(Actor.class);
    }
}
