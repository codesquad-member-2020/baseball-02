package kr.codesquad.baseball.web.controller;

import kr.codesquad.baseball.business.service.TeamService;
import kr.codesquad.baseball.web.dto.SimpleTeamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/teams")
@RestController
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<SimpleTeamDto>> teamList() {
        return ResponseEntity.ok(teamService.findAll());
    }
}
