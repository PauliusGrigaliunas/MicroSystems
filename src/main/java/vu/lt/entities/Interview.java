package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Interview.findAll", query = "select t from Interview as t")
})
@Table(name = "INTERVIEW")
@Getter @Setter
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name="CANDIDATE_ID")


    private Candidate candidate;

    public Interview(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(name, interview.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}