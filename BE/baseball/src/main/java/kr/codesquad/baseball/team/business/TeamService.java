package kr.codesquad.baseball.team.business;

import kr.codesquad.baseball.team.data.Team;
import kr.codesquad.baseball.team.data.TeamDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamDAO teamDAO;

    public List<Team> selectAll() {
        return teamDAO.selectAll();
    }
}
