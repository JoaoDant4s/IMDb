package persistance;

import model.Actor;
import model.Director;
import model.Movie;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Database {
    private static final Hashtable<Integer, Movie> movies = new Hashtable<>();
    private static final Hashtable<Integer, Actor> actors = new Hashtable<>();
    private static final Hashtable<Integer, Director> directors = new Hashtable<>();

    private static Hashtable getTable(Class clazz){
        if(clazz == Movie.class){
            return movies;
        } else if(clazz == Actor.class){
            return actors;
        } else if(clazz == Director.class){
            return directors;
        } else {
            throw new IllegalArgumentException("Unsupported class: " + clazz.getName());
        }
    }
    public static void save(Long id, Object object){
        Hashtable ht = getTable(object.getClass());
        ht.put(id, object);
    }
    public static void delete(Class clazz, Long id){
        Hashtable ht = getTable(clazz);
        ht.remove(id);
    }
    public static List getAllByClass(Class clazz){
        Hashtable ht = getTable(clazz);
        return new ArrayList(ht.values());
    }

    public static Object getByClassAndId(Class clazz, Long id){
        Hashtable ht = getTable(clazz);
        return ht.get(id);
    }


}
