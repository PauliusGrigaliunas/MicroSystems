package vu.lt.entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Position.findAll", query = "select a from Position as a")
})
@Table(name = "POSITION")
@Getter @Setter
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*@Size(max = 50)
    @Column(name = "NAME")*/
    private String name;


    public Position() {

    }

    public Position(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return  Objects.equals(id, position.id) &&
                Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
