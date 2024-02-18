package model;

import java.time.LocalDate;

public abstract class Person extends UniqueId{
    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        super();
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
