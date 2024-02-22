package view;

import view.movie.NewMovieView;

public class MainMenu extends AbstractMenu {
    public MainMenu(){
        super(new String[]{
                "1 - Cadastrar filme",
                "2 - Listar filmes",
                "3 - Buscar filme",
                "4 - Sair"
        });
    }

    @Override
    protected Boolean validateChoice(Integer choice){
        return choice >= 1 && choice <= 4;
    }

    @Override
    protected void executeChoice(Integer choice){
        switch (choice){
            case 1 -> new NewMovieView().execute();
            case 2 -> System.out.println("WIP");
            case 3 -> System.out.println("WIP");
            case 4 -> System.exit(1);
        }
        execute();
    }
}
