package kr.codesquad.baseball.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class TeamDto {

    private Integer id;
    private String name;
    private PitcherDto pitcher;
    private List<BatterDto> batters = new ArrayList<>();
}
