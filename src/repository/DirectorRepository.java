package repository;

import model.Director;

import java.util.List;

public class DirectorRepository extends AbstractRepository{

    public void saveDirector(Director director){
        save(director.getId(), director);
    }
    public Director getDirectorById(Long id){
        Object obj = getById(id);
        return (Director) obj;
    }

    public List<Director> getAllDirectors(){
        List list = getAll();
        return (List<Director>) list;
    }

    @Override
    protected Class getModelClass(){ return Director.class; }
}
