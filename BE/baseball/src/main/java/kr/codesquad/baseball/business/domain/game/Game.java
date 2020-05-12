package kr.codesquad.baseball.business.domain.game;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class Game {

    private final int id;
    private final LocalDateTime playDate;
    private final int home;
    private final int away;
}
