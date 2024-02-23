package repository;

import model.Movie;

import java.util.List;

public class MovieRepository extends AbstractRepository{

    public void saveMovie(Movie movie){ save(movie.getId(), movie);}
    public Movie getMovieById(Long id){
        Object obj = getById(id);
        return (Movie) obj;
    }

    public List<Movie> getAllMovies(){
        List list = getAll();
        return (List<Movie>) list;
    }

    @Override
    protected Class getModelClass(){ return Movie.class; }
}
