package kr.codesquad.baseball.web.dto.view;

import kr.codesquad.baseball.web.dto.TeamDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitialInfoView {

    private int gameId;
    private TeamDto homeTeam;
    private TeamDto awayTeam;
}
