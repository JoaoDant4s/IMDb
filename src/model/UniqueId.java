package model;

public class UniqueId {
    private static int idIncrementer = 1;
    private final int id;

    public UniqueId() {
        this.id = idIncrementer;
        idIncrementer++;
    }

    public int getId() {
        return id;
    }
}
