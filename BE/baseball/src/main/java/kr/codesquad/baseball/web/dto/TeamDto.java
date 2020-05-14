package kr.codesquad.baseball.web.dto;

import kr.codesquad.baseball.business.domain.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class TeamDto {

    private Integer id;
    private String name;
    private BatterDto lastBatter;
    private PitcherDto pitcher;
    private List<BatterDto> batters = new ArrayList<>();

    @Builder
    private TeamDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TeamDto of(Team team) {
        return TeamDto.builder().id(team.getId()).name(team.getName()).build();
    }
}
