package kr.codesquad.baseball.business.service;

import kr.codesquad.baseball.business.domain.game.Game;
import kr.codesquad.baseball.business.domain.game.GameDao;
import kr.codesquad.baseball.business.domain.inning.InningDao;
import kr.codesquad.baseball.common.error.exception.GameNotFoundException;
import kr.codesquad.baseball.common.error.exception.GameNotInitializedException;
import kr.codesquad.baseball.web.dto.GameDto;
import kr.codesquad.baseball.web.dto.InningDto;
import kr.codesquad.baseball.web.dto.TeamDto;
import kr.codesquad.baseball.web.view.InitialGameInfoView;
import kr.codesquad.baseball.web.view.InitialTeamView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class GameService {

    private final GameDao gameDao;
    private final InningDao inningDao;
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

    public GameDto findGameById(int id) {
        Game game = gameDao.findById(id).orElseThrow(GameNotFoundException::new);
        log.debug("Game 도메인 객체: {}", game);

        TeamDto homeTeam = teamService.findByTeamId(game.getHome());
        log.debug("Home 팀 Dto: {}", homeTeam);

        TeamDto awayTeam = teamService.findByTeamId(game.getAway());
        log.debug("Away 팀 Dto: {}", awayTeam);

        InningDto lastInning = new InningDto(inningDao.findLastInningByGameId(id).orElseThrow(GameNotInitializedException::new));
        log.debug("최근 이닝정보: {}", lastInning);

        List<InningDto> innings = inningDao.findInningListByGameId(id).stream().map(InningDto::new).collect(Collectors.toList());
        log.debug("Game의 Inning 목록: {}", innings);

        return GameDto.builder()
                      .id(game.getId())
                      .home(homeTeam)
                      .away(awayTeam)
                      .playDate(game.getPlayDate())
                      .lastInning(lastInning)
                      .innings(innings)
                      .build();
    }
}
