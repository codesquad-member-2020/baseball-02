package kr.codesquad.baseball.common.oauth.github;

import kr.codesquad.baseball.business.domain.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitHubUser {

    private String login;
    private String name;
    private String email;
    private String token;

    public User transformToUser() {
        return User.builder().userId(login).nickname(name).email(email).githubToken(token).build();
    }
}
