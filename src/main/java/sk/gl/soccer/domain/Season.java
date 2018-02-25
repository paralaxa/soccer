package sk.gl.soccer.domain;

import java.io.Serializable;
import java.util.Set;

public class Season implements Serializable{

    private Long id;
    private String name;
    private Set<Round> rounds;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Set<Round> rounds) {
        this.rounds = rounds;
    }
}
