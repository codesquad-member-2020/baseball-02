package kr.codesquad.baseball.web.dto;

import kr.codesquad.baseball.business.domain.player.pitcher.Pitcher;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PitcherDto {

    private int id;
    private String name;
    private int backNumber;

    @Builder
    private PitcherDto(int id, String name, int backNumber) {
        this.id = id;
        this.name = name;
        this.backNumber = backNumber;
    }

    public static PitcherDto of(Pitcher pitcher) {
        return PitcherDto.builder().id(pitcher.getId()).name(pitcher.getName()).backNumber(pitcher.getBackNumber()).build();
    }
}
