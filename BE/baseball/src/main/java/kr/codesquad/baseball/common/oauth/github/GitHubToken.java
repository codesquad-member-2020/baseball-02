package kr.codesquad.baseball.common.oauth.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitHubToken {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("scope")
    private String scope;
}
