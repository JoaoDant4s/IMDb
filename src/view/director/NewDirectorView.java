package view.director;

import model.Actor;
import model.Director;
import service.ActorService;
import service.DirectorService;

public class NewDirectorView {
    private DirectorService directorService;

    public NewDirectorView(){
       this.directorService = new DirectorService();
    }

//    public Director createDirector(){
//
//    }
}
