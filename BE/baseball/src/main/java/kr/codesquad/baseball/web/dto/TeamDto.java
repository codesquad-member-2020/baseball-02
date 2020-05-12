package kr.codesquad.baseball.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TeamDto {

    private Integer id;
    private String name;
    private PitcherDto pitcher;
    private List<BatterDto> batters = new ArrayList<>();
}
