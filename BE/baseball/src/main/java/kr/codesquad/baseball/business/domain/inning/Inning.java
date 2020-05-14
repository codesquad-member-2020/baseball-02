package kr.codesquad.baseball.business.domain.inning;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Inning {

    private final Integer id;
    private final Integer inningNumber;
    private final Boolean isFirst;
    private final Integer strikeCount;
    private final Integer ballCount;
    private final Integer outCount;
    private final Integer score;
}
