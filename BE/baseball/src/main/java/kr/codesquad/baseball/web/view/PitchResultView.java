package kr.codesquad.baseball.web.view;

import kr.codesquad.baseball.common.constants.PitchResult;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class PitchResultView {

    private PitchResult pitchResult;
    private EventView events;
    private InitialBatterView batter;
    private List<InitialBatterView> base;
}
