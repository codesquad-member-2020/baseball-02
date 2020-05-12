package kr.codesquad.baseball.web.view;

import kr.codesquad.baseball.web.dto.PitcherDto;
import kr.codesquad.baseball.web.dto.TeamDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class InitialTeamView {

    private Integer id;
    private String name;
    private PitcherDto pitcher;
    private List<InitialBatterView> batters = new ArrayList<>();

    private InitialTeamView(TeamDto teamDto) {
        this.id = teamDto.getId();
        this.name = teamDto.getName();
        this.pitcher = teamDto.getPitcher();
        this.batters = teamDto.getBatters().stream().map(InitialBatterView::new).collect(Collectors.toList());
    }

    public static InitialTeamView of(TeamDto teamDto) {
        return new InitialTeamView(teamDto);
    }
}
