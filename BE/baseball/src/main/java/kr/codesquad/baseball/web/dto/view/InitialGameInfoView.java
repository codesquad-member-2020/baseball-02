package kr.codesquad.baseball.web.dto.view;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InitialGameInfoView {

    private int gameId;
    private InitialTeamView homeTeam;
    private InitialTeamView awayTeam;
}
