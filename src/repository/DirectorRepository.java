package repository;

import model.Director;

import java.util.List;

public class DirectorRepository extends AbstractRepository{
    public Director getDirectorById(Long id){
        Object obj = getByIdClassAndId(id, Director.class);
        return (Director) obj;
    }

    public List<Director> getAllDirectors(){
        List list = getAllByClass(Director.class);
        return (List<Director>) list;
    }
}
