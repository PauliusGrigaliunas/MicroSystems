package vu.lt.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import vu.lt.entities.Candidate;
import vu.lt.persistence.CandidatesDAO;

@Model
public class Candidates implements Serializable {

    @Inject
    private CandidatesDAO candidatesDAO;

    private Candidate candidateToCreate = new Candidate();



    private List<Candidate> allCandidates;
    @PostConstruct
    public void init(){
        loadCandidates();
    }

    public void loadCandidates() {
        // TODO this is a mock implementation - later we will connect it to real data store
        /*List<Candidate> candidates1 = new ArrayList<>();
        candidates1.add(new Candidate("Paulius", "Grigaliunas"));
        candidates1.add(new Candidate("Kobe", "Brian"));
        candidates1.add(new Candidate("Jonas", "Maciulis"));
        this.allCandidates = candidates1;*/
        this.allCandidates = candidatesDAO.loadAll();
    }


    public List<Candidate> getAllCandidates(){
        return allCandidates;
    }

    @Transactional
    public String createCandidate(){
        this.candidatesDAO.persist(candidateToCreate);
        return "success";
    }

    public Candidate getCandidateToCreate() {
        return candidateToCreate;
    }

    public void setCandidateToCreate(Candidate candidateToCreate) {
        this.candidateToCreate = candidateToCreate;
    }
}