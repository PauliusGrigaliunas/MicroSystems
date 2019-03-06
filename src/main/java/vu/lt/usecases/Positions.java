package vu.lt.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;
import vu.lt.entities.Position;
import vu.lt.persistence.PositionsDAO;

@Model
public class Positions {
    @Inject
    private PositionsDAO positionsDAO;

    private Position positionToCreate = new Position();



    private List<Position> allPositions;
    @PostConstruct
    public void init(){
        loadPositions();
    }

    public void loadPositions() {
        // TODO this is a mock implementation - later we will connect it to real data store
        this.allPositions = positionsDAO.loadAll();
    }


    public List<Position> getAllPositions(){
        return allPositions;
    }

    @Transactional
    public String createPosition(){
        this.positionsDAO.persist(positionToCreate);
        return "success";
    }

    public Position getPositionToCreate() {
        return positionToCreate;
    }

    public void setPositionToCreate(Position positionToCreate) {
        this.positionToCreate = positionToCreate;
    }
}
