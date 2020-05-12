package kr.codesquad.baseball.web.controller;

import kr.codesquad.baseball.web.dto.view.InitialInfoView;
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

    @GetMapping("/initialInfo/{gameId}")
    public ResponseEntity<InitialInfoView> showInitialInfo(@PathVariable int gameId) {
        return ResponseEntity.ok(new InitialInfoView());
    }

}
