package kr.codesquad.baseball.business.domain.inning;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Inning {

    private Integer id;
    private Integer inningNumber;
    private Boolean isFirst;
    private Integer strikeCount;
    private Integer ballCount;
    private Integer outCount;
    private Integer score;
}
