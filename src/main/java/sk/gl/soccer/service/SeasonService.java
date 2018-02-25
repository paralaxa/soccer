package sk.gl.soccer.service;

import sk.gl.soccer.domain.Season;

public interface SeasonService {
    Long createSeason(Season season);

    Season findById(Long id);
}
