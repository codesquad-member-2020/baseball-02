package kr.codesquad.baseball.web.dto.view;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InitialInfoView {

    private int gameId;
    private InitialTeamView homeTeam;
    private InitialTeamView awayTeam;
}
