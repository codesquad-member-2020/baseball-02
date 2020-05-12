package kr.codesquad.baseball.web.view;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class InitialGameInfoView {

    private int gameId;
    private InitialTeamView homeTeam;
    private InitialTeamView awayTeam;
}
