package kr.codesquad.baseball.common.oauth.github;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitHubUser {

    private String login;
    private String name;
    private String email;
    private String token;
}
