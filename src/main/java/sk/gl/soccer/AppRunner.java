package sk.gl.soccer;

import sk.gl.soccer.domain.Season;
import sk.gl.soccer.repository.SeasonRepository;
import sk.gl.soccer.repository.SeasonRepositoryFileImpl;

public class AppRunner {


    public static void main(String[] args) {

        Season s = new Season();
        SeasonRepository seasonRepository = new SeasonRepositoryFileImpl();

        s.setId(1l);
        s.setName("newSeason");
        seasonRepository.create(s);

    }
}
