package kr.codesquad.baseball.web.dto;

import kr.codesquad.baseball.business.domain.inning.Inning;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class InningDto {

    private Integer id;
    private Integer inningNumber;
    private Boolean isFirst;
    private Integer strikeCount;
    private Integer ballCount;
    private Integer outCount;
    private Integer score;

    public InningDto(Inning inning) {
        this.id = inning.getId();
        this.inningNumber = inning.getInningNumber();
        this.isFirst = inning.getIsFirst();
        this.strikeCount = inning.getStrikeCount();
        this.ballCount = inning.getBallCount();
        this.outCount = inning.getOutCount();
        this.score = inning.getScore();
    }
}
