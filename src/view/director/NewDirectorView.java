package view.director;

import model.Director;
import service.DirectorService;
import service.exception.ServiceException;
import service.exception.ServiceRuntimeException;
import view.components.Input;
import view.movie.ListMoviesView;
import view.util.TerminalLettersColor;

import java.util.Scanner;

public class NewDirectorView {
    private final DirectorService directorService;
    private final ListDirectorsView listDirectorsView;
    private final ListMoviesView listMoviesView;
    private final Scanner scan;

    public NewDirectorView(){
       this.directorService = new DirectorService();
       this.scan = Input.getInstance();
       this.listDirectorsView = new ListDirectorsView();
       this.listMoviesView = new ListMoviesView();
    }

    public Director createDirector(){
        System.out.println("----Cadastro de diretor----");
        System.out.print("Digite o nome do diretor: ");
        String name = scan.nextLine();
        System.out.print("Digite a data de nascimento do diretor (DD/MM/AAAA): ");
        String birthString = scan.nextLine();
        Director director;
        try{
            director = directorService.createDirector(name, birthString);
        } catch (ServiceRuntimeException exception){
            System.err.println(exception.getMessage());
            return createDirector();
        }
        return director;
    }

    public void associateDirector(){
        listDirectorsView.listDirectors();
        System.out.print("Digite o ID do diretor para adicionar a um filme: ");
        Long directorId = scan.nextLong();
        listMoviesView.printIdAndMovieName();
        System.out.print("Digite o ID do filme para adicionar ao ator: ");
        Long movieId = scan.nextLong();
        try{
            directorService.associateDirectorAndMovie(directorId, movieId);
        } catch(ServiceException exception) {
            System.err.println(exception.getMessage());
        }

    }

    public void newDirector(){
        try{
            Director director = createDirector();
            if(director != null){
                System.out.println(TerminalLettersColor.greenOpen + "Ator criado com sucesso" + TerminalLettersColor.greenClose);
            }
        } catch(ServiceRuntimeException exception){
            System.err.println(exception.getMessage());
        }
    }

}
