package kr.codesquad.baseball.business.domain.player.pitcher;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Pitcher {

    private final int id;
    private final String name;
}
