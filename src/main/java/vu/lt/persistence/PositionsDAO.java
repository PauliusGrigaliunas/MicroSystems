package vu.lt.persistence;

import vu.lt.entities.Position;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PositionsDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Position> loadAll() {
        return em.createNamedQuery("Position.findAll", Position.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Position position){
        this.em.persist(position);
    }
}
