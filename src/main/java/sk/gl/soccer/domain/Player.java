package sk.gl.soccer.domain;

import java.io.Serializable;
import java.util.Set;

public class Player implements Serializable {

    private Long id;
    private String name;
    private String nickName;
    private Set<MatchEvent> matchEvents;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Set<MatchEvent> getMatchEvents() {
        return matchEvents;
    }

    public void setMatchEvents(Set<MatchEvent> matchEvents) {
        this.matchEvents = matchEvents;
    }
}
