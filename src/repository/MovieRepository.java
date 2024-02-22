package repository;

import model.Movie;

import java.util.List;

public class MovieRepository extends AbstractRepository{
    public Movie getDirectorById(Long id){
        Object obj = getById(id);
        return (Movie) obj;
    }

    public List<Movie> getAllDirectors(){
        List list = getAll();
        return (List<Movie>) list;
    }

    @Override
    protected Class getModelClass(){ return Movie.class; }
}
