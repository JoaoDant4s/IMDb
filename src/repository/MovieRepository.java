package repository;

import model.Movie;

import java.util.List;

public class MovieRepository extends AbstractRepository{
    public Movie getDirectorById(Long id){
        Object obj = getByIdClassAndId(id, Movie.class);
        return (Movie) obj;
    }

    public List<Movie> getAllDirectors(){
        List list = getAllByClass(Movie.class);
        return (List<Movie>) list;
    }
}
