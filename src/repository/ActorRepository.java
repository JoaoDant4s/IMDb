package repository;

import model.Actor;
import persistance.Database;

import java.util.List;

public class ActorRepository extends AbstractRepository{
    public Actor getActorById(Long id){
        Object obj = getByIdClassAndId(id, Actor.class);
        return (Actor) obj;
    }

    public List<Actor> getAllActors(){
        List list = getAllByClass(Actor.class);
        return (List<Actor>) list;
    }
}
