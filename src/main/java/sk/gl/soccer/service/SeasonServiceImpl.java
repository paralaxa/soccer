package sk.gl.soccer.service;

import sk.gl.soccer.domain.Season;
import sk.gl.soccer.repository.SeasonRepository;

public class SeasonServiceImpl implements SeasonService {

    private SeasonRepository seasonRepository;

    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public  Long createSeason(Season season) {
        return seasonRepository.create(season).getId();
    }

    @Override
    public   Season findById(Long id) {
        Season season = seasonRepository.findById(id);
        if (season == null) {
            throw new ServiceException("Season not found found id: " + id);
        }
        return season;
    }
}
