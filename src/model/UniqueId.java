package model;

public abstract class UniqueId {
    private static Long idIncrementer = 1L;
    private final Long id;

    public UniqueId() {
        this.id = idIncrementer;
        idIncrementer++;
    }

    public Long getId() {
        return id;
    }
}
