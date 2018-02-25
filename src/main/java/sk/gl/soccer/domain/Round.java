package sk.gl.soccer.domain;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Round implements Serializable {
    private Long id;
    private Long seasonId;
    private Integer order;
    private Set<Match> matches = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }
}
