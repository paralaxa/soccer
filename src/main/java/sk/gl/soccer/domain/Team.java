package sk.gl.soccer.domain;


import java.io.Serializable;
import java.util.Set;

public class Team implements Serializable {

    private Long id;
    private String name;
    private Set<Player> players;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
