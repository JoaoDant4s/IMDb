package view.director;

import model.Director;
import service.DirectorService;
import view.util.TerminalLettersColor;

import java.util.List;

public class ListDirectorsView {
    private final DirectorService directorService;

    public ListDirectorsView(){
        this.directorService = new DirectorService();
    }

    private void printDirectors(List<Director> directors){
        if(directors.isEmpty()){
            System.out.println(TerminalLettersColor.yellowOpen + "--Nenhum diretor encontrado--" + TerminalLettersColor.yellowClose);
        }
        System.out.println("Id | Nome");
        for (Director director : directors){
            System.out.println(director.getId() + "  " + director.getName());
        }
    }

    public void listDirectors(){
        List<Director> directors = directorService.listAllDirectors();
        printDirectors(directors);
    }

}
