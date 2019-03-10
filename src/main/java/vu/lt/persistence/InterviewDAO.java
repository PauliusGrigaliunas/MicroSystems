package vu.lt.persistence;

import vu.lt.entities.Interview;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class InterviewDAO {

        @PersistenceContext
        private EntityManager em;

        public List<Interview> loadAll() {
            return em.createNamedQuery("Interview.findAll", Interview.class).getResultList();
        }

        public void setEm(EntityManager em) {
            this.em = em;
        }

        public void persist(Interview interview){
            this.em.persist(interview);
        }

        public Interview findOne(Integer id) { return em.find(Interview.class, id); }
}
