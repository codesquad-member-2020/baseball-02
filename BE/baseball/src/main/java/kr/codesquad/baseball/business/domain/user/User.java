package kr.codesquad.baseball.business.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class User {

    private final String userId;
    private final String nickname;
    private final String email;
    private final String githubToken;

    public static User of(Map<String, String> userMap) {
        return new User(userMap);
    }

    private User(Map<String, String> userMap) {
        this.userId = userMap.get("userId");
        this.nickname = userMap.get("nickname");
        this.email = userMap.get("email");
        this.githubToken = userMap.get("githubToken");
    }
}
