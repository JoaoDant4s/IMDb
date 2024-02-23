package view.director;

import model.Director;
import service.DirectorService;
import service.exception.ServiceException;
import view.components.Input;

import java.util.Scanner;

public class NewDirectorView {
    private final DirectorService directorService;
    private final Scanner scan;

    public NewDirectorView(){
       this.directorService = new DirectorService();
       this.scan = Input.getInstance();
    }

    public Director createDirector(){
        System.out.println("----Cadastro do diretor----");
        System.out.print("Digite o nome do diretor: ");
        String name = scan.nextLine();
        System.out.print("Digite a data de nascimento do diretor (DD/MM/AAAA): ");
        String birthString = scan.nextLine();
        Director director;
        try{
            director = directorService.createDirector(name, birthString);
        } catch (ServiceException exception){
            System.err.println(exception.getMessage());
            return createDirector();
        }
        return director;
    }
}
