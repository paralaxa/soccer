package sk.gl.soccer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import sk.gl.soccer.domain.Match;
import sk.gl.soccer.domain.Round;
import sk.gl.soccer.domain.Season;
import sk.gl.soccer.repository.SeasonRepositoryFileImpl;

import java.io.File;
import java.util.HashSet;
import java.util.Set;


public class SeasonServiceTest {
    private static int x = 0;
    private static SeasonService seasonService;
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public TestRule getString() {
        return new TestRule() {
            @Override
            public Statement apply(Statement statement, Description description) {
                System.out.println("running "+description.getDisplayName());
                return statement;
            }
        };
    }

    @Before
    public void before() throws Exception {
        SeasonRepositoryFileImpl seasonRepository = new SeasonRepositoryFileImpl();
        File createdFile = folder.newFile("season.obj");
        seasonRepository.setFileName(createdFile.getAbsolutePath());
        seasonService = new SeasonServiceImpl(seasonRepository);
    }

    @Test
    public void createSeason() throws Exception {
        System.out.println("season");
        Season season = new Season();
        season.setId(1l);
        season.setName("seasonName");
        Round round1 = new Round();
        round1.setOrder(1);
        round1.setId(1l);
        Set<Round> rounds = new HashSet<>();
        rounds.add(round1);
        season.setRounds(rounds);
        Match match1 = new Match();
        match1.setId(1l);
        match1.setRoundId(1l);
        Set<Match> matches = new HashSet<>();
        matches.add(match1);
        round1.setMatches(matches);

        seasonService.createSeason(season);
        season.setId(2l);
        seasonService.createSeason(season);
        Season byId = seasonService.findById(1l);
        Assert.assertTrue(byId.getName().equals("seasonName"));
        Season byId2 = seasonService.findById(2l);
        Assert.assertTrue(byId.getName().equals("seasonName"));
        //todo test matches count, rounds ....
    }

    @Test
    public void findById() throws Exception {
        System.out.println("find");

        //todo first create (use @Before annotated method)
        Season byId = seasonService.findById(1l);
        Assert.assertNotNull(byId);

    }
}
