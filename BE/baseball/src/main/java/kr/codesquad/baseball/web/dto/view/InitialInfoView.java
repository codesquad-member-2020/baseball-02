package kr.codesquad.baseball.web.dto.view;

import kr.codesquad.baseball.web.dto.TeamDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InitialInfoView {

    private int gameId;
    private TeamDto homeTeam;
    private TeamDto awayTeam;
}
