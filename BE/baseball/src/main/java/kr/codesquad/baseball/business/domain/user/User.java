package kr.codesquad.baseball.business.domain.user;

import kr.codesquad.baseball.common.oauth.github.GitHubUser;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class User {

    private final String userId;
    private final String nickname;
    private final String email;
    private final String githubToken;

    public static User of(GitHubUser gitHubUser) {
        return User.builder()
                   .userId(gitHubUser.getLogin())
                   .nickname(gitHubUser.getName())
                   .email(gitHubUser.getEmail())
                   .githubToken(gitHubUser.getToken())
                   .build();
    }
}
