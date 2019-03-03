package vu.lt.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import vu.lt.entities.Candidate;

@Model
public class Candidates implements Serializable {

    private List<Candidate> allPlayers;
    @PostConstruct
    public void init(){
        loadPlayers();
    }

    public void loadPlayers() {
        // TODO this is a mock implementation - later we will connect it to real data store
        List<Candidate> candidates = new ArrayList<Candidate>();
        candidates.add(new Candidate("Paulius", "Grigaliunas"));
        candidates.add(new Candidate("Kobe", "Brian"));
        //candidates.add(new Candidate("Robbert"));
        this.allPlayers = candidates;
    }

    public List<Candidate> getAllCandidates(){
        return allPlayers;
    }
}