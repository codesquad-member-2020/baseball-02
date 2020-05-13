package kr.codesquad.baseball.web.view;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class EventView {

    private boolean isThreeStrike;
    private boolean isFourBall;
    private boolean isChangeAttackTeam;
    private boolean isEndGame;
}
