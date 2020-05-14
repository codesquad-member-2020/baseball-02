package kr.codesquad.baseball.team.web;

import kr.codesquad.baseball.team.business.TeamService;
import kr.codesquad.baseball.team.data.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/team")
@RestController
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/list")
    public ResponseEntity<List<Team>> list() {
        return ResponseEntity.ok(teamService.selectAll());
    }
}
