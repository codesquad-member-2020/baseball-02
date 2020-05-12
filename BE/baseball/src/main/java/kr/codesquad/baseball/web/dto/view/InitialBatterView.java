package kr.codesquad.baseball.web.dto.view;

import kr.codesquad.baseball.web.dto.BatterDto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class InitialBatterView {

    private int id;
    private String name;

    public InitialBatterView(BatterDto batterDto) {
        this.id = batterDto.getId();
        this.name = batterDto.getName();
    }
}
