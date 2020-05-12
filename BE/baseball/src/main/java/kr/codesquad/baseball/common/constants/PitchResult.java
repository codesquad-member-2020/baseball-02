package kr.codesquad.baseball.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PitchResult {

    STRIKE("strike"),
    BALL("ball"),
    OUT("out"),
    HIT("hit");

    private String action;
}
