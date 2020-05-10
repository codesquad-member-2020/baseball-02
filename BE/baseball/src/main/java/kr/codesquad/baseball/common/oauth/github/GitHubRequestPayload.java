package kr.codesquad.baseball.common.oauth.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GitHubRequestPayload {

    @JsonProperty("client_id")
    private final String clientId = System.getenv("GITHUB_CLIENT_ID");

    @JsonProperty("client_secret")
    private final String clientSecret = System.getenv("GITHUB_CLIENT_SECRET");

    private final String code;

    private GitHubRequestPayload(String code) {
        this.code = code;
    }

    public static GitHubRequestPayload valueOf(String code) {
        return new GitHubRequestPayload(code);
    }

}
