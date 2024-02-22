package repository;

import persistance.Database;

import java.util.List;

public abstract class AbstractRepository {
    public Object getByIdClassAndId(Long id, Class clazz){
        return Database.getByClassAndId(clazz, id);
    };
    public List getAllByClass(Class clazz){
        return Database.getAllByClass(clazz);
    };
}
