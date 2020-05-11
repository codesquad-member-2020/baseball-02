package kr.codesquad.baseball.business.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Team {

    private Integer id;
    private String name;
    private Integer lastBatter;

    @Builder
    public Team(Integer id, String name, Integer lastBatter) {
        this.id = id;
        this.name = name;
        this.lastBatter = lastBatter;
    }
}
