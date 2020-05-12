package kr.codesquad.baseball.business.service;

import kr.codesquad.baseball.business.domain.TeamDao;
import kr.codesquad.baseball.business.domain.player.batter.BatterDao;
import kr.codesquad.baseball.business.domain.player.pitcher.PitcherDao;
import kr.codesquad.baseball.web.dto.BatterDto;
import kr.codesquad.baseball.web.dto.PitcherDto;
import kr.codesquad.baseball.web.dto.SimpleTeamDto;
import kr.codesquad.baseball.web.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamDao teamDao;
    private final BatterDao batterDao;
    private final PitcherDao pitcherDao;

    public List<SimpleTeamDto> findAll() {
        return teamDao.selectAll().stream()
                .map(SimpleTeamDto::new)
                .collect(Collectors.toList());
    }

    public TeamDto findByTeamId(int id) {
        TeamDto teamDto = TeamDto.of(teamDao.findById(id));
        teamDto.setPitcher(PitcherDto.of(pitcherDao.findByTeamId(id)));
        teamDto.setBatters(batterDao.findByTeamId(id).stream().map(BatterDto::new).collect(Collectors.toList()));
        return teamDto;
    }
}
