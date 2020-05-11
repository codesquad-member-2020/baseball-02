package kr.codesquad.baseball.web.dto;

import kr.codesquad.baseball.business.domain.Team;
import lombok.Getter;

@Getter
public class SimpleTeamDto {

    private Integer id;
    private String name;
    private Integer lastBatter;

    public SimpleTeamDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.lastBatter = team.getLastBatter();
    }

}
