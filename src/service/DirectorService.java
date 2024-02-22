package service;

import repository.DirectorRepository;

public class DirectorService {
    DirectorRepository directorRepository;

    public DirectorService(){
        this.directorRepository = new DirectorRepository();
    }

    public void newDirector(){}
}
