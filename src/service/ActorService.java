package service;

import model.Actor;
import model.Movie;
import repository.ActorRepository;
import repository.MovieRepository;
import service.exception.InvalidModelException;
import service.exception.NotFoundException;
import service.exception.ServiceException;

import java.time.LocalDate;
import java.util.List;

public class ActorService extends AbstractValidateService{
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public ActorService(){
        this.actorRepository = new ActorRepository();
        this.movieRepository = new MovieRepository();
    }

    public void createActors(List<Actor> actors) throws ServiceException {
        for(Actor actor : actors){
            if(actorRepository.getActorByName(actor.getName()) != null) {
                actors.remove(actor);
                throw new ServiceException("Ator já cadastrado", new Exception());
            }
            actorRepository.saveActor(actor);
        }
    }

    public List<Actor> listAllActors(){
        return actorRepository.getAllActors();
    }

    public Actor actorToBeCreated(String name, String birthString){
        validate(name, birthString, "Ator");
        LocalDate birthDate = convertDate(birthString);
        return birthDate != null ? new Actor(name, birthDate) : null;
    }

    public void associateActorAndMovie(Long actorId, Long movieId) throws ServiceException {
        try{
            if(actorId == null || movieId == null) throw new InvalidModelException("Valores passados nulos");
            Movie movie = movieRepository.getMovieById(movieId);
            if(movie == null) throw new NotFoundException("Não existe nenhum filme com esse ID");
            Actor actor = actorRepository.getActorById(actorId);
            if(actor == null) throw new NotFoundException("Não existe nenhum ator com esse ID");
            if(movie.getActors().contains(actor)) throw new NotFoundException("O ator já está incluído no filme");
            movie.addActors(actor);
            actor.addParticipatedMovie(movie.getId());
        } catch( InvalidModelException | NotFoundException exception){
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
