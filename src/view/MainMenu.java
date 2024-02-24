package view;

import view.actor.NewActorView;
import view.director.NewDirectorView;
import view.movie.ListMoviesView;
import view.movie.NewMovieView;

public class MainMenu extends AbstractMenu {
    public MainMenu(){
        super(new String[]{
                "1 - Cadastrar filme",
                "2 - Listar filmes",
                "3 - Buscar filme",
                "4 - Criar ator",
                "5 - Associar atores ao filme",
                "6 - Criar diretor",
                "7 - Associar diretores ao filme",
                "8 - Sair"
        });
    }

    @Override
    protected Boolean validateChoice(Integer choice){
        return choice >= 1 && choice <= 8;
    }

    @Override
    protected void executeChoice(Integer choice){
        switch (choice){
            case 1 -> new NewMovieView().execute();
            case 2 -> new ListMoviesView().listMovies();
            case 3 -> new ListMoviesView().findMovie();
            case 4 -> new NewActorView().newActor();
            case 5 -> new NewActorView().associateActor();
            case 6 -> new NewDirectorView().newDirector();
            case 7 -> new NewDirectorView().associateDirector();
            case 8 -> System.exit(1);
        }
        execute();
    }
}
