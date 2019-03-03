package vu.lt.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import vu.lt.entities.Player;

@Model
public class Players implements Serializable {

    private List<Player> allPlayers;
    @PostConstruct
    public void init(){
        loadPlayers();
    }

    public void loadPlayers() {
        // TODO this is a mock implementation - later we will connect it to real data store
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Jordan"));
        players.add(new Player("Kobe"));
        players.add(new Player("Robbert"));
        this.allPlayers = players;
    }

    public List<Player> getAllPlayers(){
        return allPlayers;
    }
}