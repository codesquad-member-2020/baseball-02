package kr.codesquad.baseball.web.dto;

import kr.codesquad.baseball.business.domain.player.batter.Batter;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BatterDto {

    private int id;
    private String name;
    private int backNumber;
    private int battingNumber;
    private int hitRate;

    public BatterDto(Batter batter) {
        this.id = batter.getId();
        this.name = batter.getName();
        this.backNumber = batter.getBackNumber();
        this.battingNumber = batter.getBattingNumber();
        this.hitRate = batter.getHitRate();
    }
}
