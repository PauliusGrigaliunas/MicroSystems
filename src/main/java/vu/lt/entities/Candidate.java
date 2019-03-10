package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Candidate.findAll", query = "select a from Candidate as a")
})
@Table(name = "CANIDATE")
@Getter @Setter
public class Candidate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "candidate" , fetch = FetchType.EAGER)
    private List<Interview> Interviews = new ArrayList<>();

    public Candidate() {

    }

    public Candidate(String name, String surname) {
        this.name = name;
        this.surname = surname;
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