package service;

import model.Director;
import repository.DirectorRepository;

import java.time.LocalDate;

public class DirectorService extends AbstractPersonService{
    DirectorRepository directorRepository;

    public DirectorService(){
        this.directorRepository = new DirectorRepository();
    }

    public Director createDirector(String name , String birthString){
        validate(name, birthString, "Diretor");
        LocalDate birthDate = convertDate(birthString);
        if(birthDate == null) return null;
        Director director = new Director(name, birthDate);
        directorRepository.saveDirector(director);
        return director;
    }
}
