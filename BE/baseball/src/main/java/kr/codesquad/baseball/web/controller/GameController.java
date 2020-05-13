package kr.codesquad.baseball.web.controller;

import kr.codesquad.baseball.business.service.GameService;
import kr.codesquad.baseball.common.constants.PitchResult;
import kr.codesquad.baseball.common.error.exception.NotYourPitchTurnException;
import kr.codesquad.baseball.web.dto.GameDto;
import kr.codesquad.baseball.web.view.EventView;
import kr.codesquad.baseball.web.view.InitialBatterView;
import kr.codesquad.baseball.web.view.InitialGameInfoView;
import kr.codesquad.baseball.web.view.PitchResultView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/game")
@RestController
public class GameController {

    private final GameService gameService;

    @GetMapping("/{gameId}/initialInfo")
    public ResponseEntity<InitialGameInfoView> showInitialInfo(@PathVariable int gameId) {
        log.debug("찾으려는 Game Id: {}", gameId);

        InitialGameInfoView gameView = gameService.findInitialGameInfoById(gameId);
        log.debug("Game 초기 정보: {}", gameView);

        return ResponseEntity.ok(gameView);
    }

    @GetMapping("/{gameId}/currentInfo")
    public ResponseEntity<GameDto> currentGameInfo(@PathVariable int gameId) {
        GameDto game = gameService.findGameById(gameId);
        log.debug("Game 정보: {}", game);

        return ResponseEntity.ok(game);
    }

    @GetMapping("/{gameId}/{teamId}/pitch")
    public ResponseEntity<PitchResultView> pitch(@PathVariable int gameId, @PathVariable int teamId) {
        GameDto game = gameService.findGameById(gameId);
        log.debug("Game 정보: {}", game);

        if (game.isAttackTeam(teamId)) {
            throw new NotYourPitchTurnException();
        }

        EventView event = EventView.builder().isThreeStrike(true).isChangeAttackTeam(true).build();
        List<InitialBatterView> base = game.getHome()
                                           .getBatters()
                                           .stream()
                                           .filter(b -> b.getBattingNumber() > 6)
                                           .map(InitialBatterView::new)
                                           .collect(Collectors.toList());

        PitchResultView pitchResult = PitchResultView.builder()
                                                     .pitchResult(PitchResult.STRIKE)
                                                     .events(event)
                                                     .batter(new InitialBatterView(game.getHome().getLastBatter()))
                                                     .base(base)
                                                     .build();

        return ResponseEntity.ok(pitchResult);
    }
}
