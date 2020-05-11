package kr.codesquad.baseball.business.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class User {

    private final String id;
    private final String nickname;
    private final String email;
}
