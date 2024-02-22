package repository;

import persistance.Database;

import java.util.List;

public abstract class AbstractRepository {
    public void save(Long id, Object object){
        Database.save(id, object, getModelClass());
    }
    public Object getById(Long id){
        return Database.getByClassAndId(getModelClass(), id);
    };
    public List getAll(){
        return Database.getAllByClass(getModelClass());
    };

    protected abstract Class getModelClass();
}
