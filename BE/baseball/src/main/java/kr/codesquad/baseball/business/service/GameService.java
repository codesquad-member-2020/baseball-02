package kr.codesquad.baseball.business.service;

import kr.codesquad.baseball.business.domain.game.Game;
import kr.codesquad.baseball.business.domain.game.GameDao;
import kr.codesquad.baseball.common.error.exception.GameNotFoundException;
import kr.codesquad.baseball.web.view.InitialGameInfoView;
import kr.codesquad.baseball.web.view.InitialTeamView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GameService {

    private final GameDao gameDao;
    private final TeamService teamService;

    public InitialGameInfoView findInitialGameInfoById(int id) {
        Game game = gameDao.findById(id).orElseThrow(GameNotFoundException::new);
        log.debug("Game 도메인 객체: {}", game);

        InitialTeamView homeTeam = InitialTeamView.of(teamService.findByTeamId(game.getHome()));
        log.debug("Home 팀 View: {}", homeTeam);

        InitialTeamView awayTeam = InitialTeamView.of(teamService.findByTeamId(game.getAway()));
        log.debug("Away 팀 View: {}", awayTeam);

        return InitialGameInfoView.builder().gameId(game.getId()).homeTeam(homeTeam).awayTeam(awayTeam).build();
    }
}
