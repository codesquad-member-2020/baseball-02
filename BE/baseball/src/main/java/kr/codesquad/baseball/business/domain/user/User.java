package kr.codesquad.baseball.business.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
@RequiredArgsConstructor
public class User {

    private final String id;
    private final String nickname;
    private final String email;

    public static User of(Map<String, String> userMap) {
        return new User(userMap);
    }

    private User(Map<String, String> userMap) {
        this.id = userMap.get("id");
        this.nickname = userMap.get("nickname");
        this.email = userMap.get("email");
    }
}
