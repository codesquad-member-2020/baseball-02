package kr.codesquad.baseball.business.domain.player.batter;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Batter {

    private final int id;
    private final String name;
    private final int backNumber;
    private final int battingNumber;
    private final int hitRate;
}
