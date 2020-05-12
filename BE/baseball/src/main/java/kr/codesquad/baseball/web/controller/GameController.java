package kr.codesquad.baseball.web.controller;

import kr.codesquad.baseball.business.service.GameService;
import kr.codesquad.baseball.web.view.InitialGameInfoView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/game")
@RestController
public class GameController {

    private final GameService gameService;

    @GetMapping("/initialInfo/{gameId}")
    public ResponseEntity<InitialGameInfoView> showInitialInfo(@PathVariable int gameId) {
        log.debug("찾으려는 Game Id: {}", gameId);

        InitialGameInfoView gameView = gameService.findInitialGameInfoById(gameId);
        log.debug("Game 초기 정보: {}", gameView);

        return ResponseEntity.ok(gameView);
    }

}
