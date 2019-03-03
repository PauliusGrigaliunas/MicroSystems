package vu.lt.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CANDIDATE")
public class Candidate implements Serializable {

    private String name;
    private String surname;
    private String id;

    public Candidate() {
    }

    public Candidate(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String name) {
        this.surname = name;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return  Objects.equals(id, candidate.id) &&
                Objects.equals(name, candidate.name) &&
                Objects.equals(surname, candidate.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }
}