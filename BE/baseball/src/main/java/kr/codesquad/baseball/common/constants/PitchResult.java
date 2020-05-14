package kr.codesquad.baseball.common.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PitchResult {

    STRIKE("strike"),
    BALL("ball"),
    OUT("out"),
    HIT("hit");

    @JsonValue
    private String action;
}
