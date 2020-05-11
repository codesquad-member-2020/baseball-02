package kr.codesquad.baseball.business.service;

import kr.codesquad.baseball.business.domain.TeamDao;
import kr.codesquad.baseball.web.dto.SimpleTeamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamDao teamDao;

    public List<SimpleTeamDto> findAll() {
        return teamDao.selectAll().stream()
                .map(SimpleTeamDto::new)
                .collect(Collectors.toList());
    }
}
