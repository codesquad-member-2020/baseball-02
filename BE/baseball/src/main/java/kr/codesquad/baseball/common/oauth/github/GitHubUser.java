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

    public User transformToUser() {
        return new User(this.login, this.name, this.email);
    }
}
