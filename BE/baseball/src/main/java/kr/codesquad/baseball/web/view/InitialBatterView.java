package kr.codesquad.baseball.web.view;

import kr.codesquad.baseball.web.dto.BatterDto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class InitialBatterView {

    private int id;
    private String name;
    private int backNumber;
    private int atBat;
    private int hit;

    public InitialBatterView(BatterDto batterDto) {
        this.id = batterDto.getId();
        this.name = batterDto.getName();
        this.backNumber = batterDto.getBackNumber();
        this.atBat = 0;
        this.hit = 0;
    }
}
