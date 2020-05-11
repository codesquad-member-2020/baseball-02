package kr.codesquad.baseball.common.oauth.github;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.codesquad.baseball.business.domain.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GitHubOAuthService {

    private static final String GITHUB_USER_API_URL = "https://api.github.com/user";
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public GitHubOAuthService(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    public GitHubToken getGitHubTokenToCode(String code) {
        HttpEntity<GitHubRequestPayload> request = new HttpEntity<>(GitHubRequestPayload.valueOf(code));
        String accessTokenUrl = "https://github.com/login/oauth/access_token";
        return restTemplate.postForEntity(accessTokenUrl, request, GitHubToken.class).getBody();
    }

    // TODO: 유저정보 저장용 DB 설계하고 저장하기
    public User insertUserInfo(String token) {
        return getGitHubUserInfoToToken(token).transformToUser();
    }

    public GitHubUser getGitHubUserInfoToToken(String token) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Authorization", "token " + token);
        GitHubUser user = restTemplate.exchange(GITHUB_USER_API_URL, HttpMethod.GET, new HttpEntity<>(requestHeaders), GitHubUser.class).getBody();

        if (user.getEmail() == null) {
            user.setEmail(getEmailFromGitHub(requestHeaders));
        }

        return user;
    }

    @Nullable
    public String getEmailFromGitHub(HttpHeaders requestHeaders) {
        String email = restTemplate.exchange(GITHUB_USER_API_URL + "/emails", HttpMethod.GET, new HttpEntity<>(requestHeaders), String.class).getBody();

        try {
            JsonNode emailNode = objectMapper.readTree(email);
            for (JsonNode jsonNode : emailNode) {
                if (jsonNode.get("primary").asBoolean()) {
                    return jsonNode.get("email").textValue();
                }
            }
        } catch (JsonProcessingException e) {
            log.error("Json 형식이 잘못되었어요.", e);
        }
        return null;
    }
}
