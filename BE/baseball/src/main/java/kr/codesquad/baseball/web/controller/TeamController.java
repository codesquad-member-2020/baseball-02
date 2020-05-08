package kr.codesquad.baseball.web.controller;

import kr.codesquad.baseball.business.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/teams")
@RestController
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<Object> teamList() {
        return ResponseEntity.ok(teamService.findAll());
    }
}
