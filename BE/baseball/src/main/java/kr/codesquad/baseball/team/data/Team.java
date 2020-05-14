package kr.codesquad.baseball.team.data;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class Team {

    private final Integer id;
    private final String name;
}
