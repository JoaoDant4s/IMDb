package repository;

import model.Actor;

import java.util.List;

public class ActorRepository extends AbstractRepository{
    public void saveActor(Actor actor){
        save(actor.getId(), actor);
    }
    public Actor getActorById(Long id){
        Object obj = getById(id);
        return (Actor) obj;
    }

    public Actor getActorByName(String name){
        List<Actor> list = getAll();
        for(Actor actor : list){
            if(actor.getName().equalsIgnoreCase(name)) return actor;
        }
        return null;
    }

    public List<Actor> getAllActors(){
        List list = getAll();
        return (List<Actor>) list;
    }

    @Override
    protected Class getModelClass(){ return Actor.class; }
}
