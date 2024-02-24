package service;

import model.Director;
import model.Movie;
import repository.DirectorRepository;
import repository.MovieRepository;
import service.exception.InvalidModelException;
import service.exception.NotFoundException;
import service.exception.ServiceException;
import service.exception.ServiceRuntimeException;

import java.time.LocalDate;
import java.util.List;

public class DirectorService extends AbstractValidateService{
    DirectorRepository directorRepository;
    MovieRepository movieRepository;

    public DirectorService(){
        this.directorRepository = new DirectorRepository();
        this.movieRepository = new MovieRepository();
    }

    public Director createDirector(String name , String birthString){
        Director director;
        try{
            validate(name, birthString, "Diretor");
            LocalDate birthDate = convertDate(birthString);
            if(birthDate == null) return null;
            director = new Director(name, birthDate);
            directorRepository.saveDirector(director);
        } catch (ServiceRuntimeException exception){
            throw exception;
        }

        return director;
    }

    public List<Director> listAllDirectors(){ return directorRepository.getAllDirectors();}

    public void associateDirectorAndMovie(Long directorId, Long movieId) throws ServiceException{
        try{
            if(directorId == null || movieId == null) throw  new InvalidModelException("Valores passados nulos");
            Director director = directorRepository.getDirectorById(directorId);
            if(director == null) throw new NotFoundException("Não existe nenhum diretor com esse ID");
            Movie movie = movieRepository.getMovieById(movieId);
            if(movie == null) throw new NotFoundException("Não existe nenhum filme com esse ID");
            if(movie.getDirector() != null) throw new InvalidModelException("O filme selecionado já tem diretor");
            movie.setDirector(director);
            director.addParticipatedMovie(movie.getId());
        } catch (InvalidModelException | NotFoundException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

}
