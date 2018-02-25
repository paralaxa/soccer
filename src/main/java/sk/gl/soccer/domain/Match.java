package sk.gl.soccer.domain;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Match implements Serializable{
    private Long id;
    private Long roundId;
    private MatchType matchType;

    private Team teamOne;
    private Team teamTwo;

    private Set<MatchEvent> matchEvents = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public Set<MatchEvent> getMatchEvents() {
        return matchEvents;
    }

    public void setMatchEvents(Set<MatchEvent> matchEvents) {
        this.matchEvents = matchEvents;
    }
}
