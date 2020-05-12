package kr.codesquad.baseball.common.oauth.github;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.codesquad.baseball.business.domain.user.User;
import kr.codesquad.baseball.business.domain.user.UserDao;
import kr.codesquad.baseball.common.error.exception.GitHubUserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class GitHubOAuthService {

    private static final String GITHUB_ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";
    private static final String GITHUB_USER_API_URL = "https://api.github.com/user";
    private final UserDao userDao;
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public GitHubToken getGitHubTokenToCode(String code) {
        HttpEntity<GitHubRequestPayload> request = new HttpEntity<>(GitHubRequestPayload.valueOf(code));
        return restTemplate.postForEntity(GITHUB_ACCESS_TOKEN_URL, request, GitHubToken.class).getBody();
    }

    public Optional<User> insertUserInfo(String token) {
        User user = getUserInfoToToken(token);
        log.debug("DB 저장 전 User 정보: {}", user);

        if (userDao.countByUserId(user) != 0 && userDao.updateUserData(user) != 0) {
            return userDao.findByUserId(user);
        }

        if (userDao.insertUserData(user) != 0) {
            return userDao.findByUserId(user);
        }
        return Optional.empty();
    }

    public User getUserInfoToToken(String token) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Authorization", "token " + token);

        GitHubUser user = Optional
                .ofNullable(restTemplate.exchange(GITHUB_USER_API_URL, HttpMethod.GET, new HttpEntity<>(requestHeaders), GitHubUser.class).getBody())
                .orElseThrow(GitHubUserNotFoundException::new);
        user.setToken(token);

        // 공개된 user email이 없는 경우가 있어서 없는 경우 email API를 사용해서 채워줍니다.
        if (user.getEmail() == null) {
            user.setEmail(getEmailFromGitHub(requestHeaders));
        }

        return User.of(user);
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
