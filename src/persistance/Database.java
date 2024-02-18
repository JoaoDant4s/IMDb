package persistance;

import model.Actor;
import model.Director;
import model.Movie;

import java.util.Hashtable;

public class Database {
    private static final Hashtable<Integer, Movie> movie = new Hashtable<>();
    private static final Hashtable<Integer, Actor> actor = new Hashtable<>();
    private static final Hashtable<Integer, Director> director = new Hashtable<>();

    public static void save(Object object){}
    public static void delete(Object object){}
    public static void getAllByClass(Class clazz){}

}
