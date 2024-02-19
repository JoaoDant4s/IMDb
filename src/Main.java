import model.Director;
import persistance.Database;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Director director1 = new Director("João Dantas", LocalDate.now());
        Director director2 = new Director("William", LocalDate.now());
        Database.save(director1.getId(), director1);
        Database.save(director2.getId(), director2);

        List directors = Database.getAllByClass(Director.class);
        for(Object object : directors){
            Director director = (Director) object;
            System.out.println("Diretor: " + director.getName());
        }

        Object obj = Database.getByClassAndId(Director.class, 1);
        Director director = (Director) obj;
        System.out.println("Diretor encontrado: " + director.getName());
    }
}