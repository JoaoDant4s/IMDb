package model;

public abstract class UniqueId {
    private static Integer idIncrementer = 1;
    private final Integer id;

    public UniqueId() {
        this.id = idIncrementer;
        idIncrementer++;
    }

    public Integer getId() {
        return id;
    }
}
