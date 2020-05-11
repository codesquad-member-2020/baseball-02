package kr.codesquad.baseball.web.controller;

import kr.codesquad.baseball.business.domain.user.User;
import kr.codesquad.baseball.common.oauth.github.GitHubOAuthService;
import kr.codesquad.baseball.common.util.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@RestController
@Slf4j
public class LoginController {

    private final GitHubOAuthService gitHubOAuthService;
    private final JwtService jwtService;

    public LoginController(GitHubOAuthService gitHubOAuthService, JwtService jwtService) {
        this.gitHubOAuthService = gitHubOAuthService;
        this.jwtService = jwtService;
    }

    // TODO: Post로 변경
    @GetMapping("/login/with-github")
    public ResponseEntity<String> loginWithGithub(@CookieValue(value = "jwt", required = false) String jwt) {
        if (jwt != null) {
            log.debug("jwt 토큰 값: {}", jwt);
            log.debug("jwt에 저장된 값: {}", jwtService.getDataFromJws("user", jwt));
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }

        HttpHeaders headers = new HttpHeaders();
        URI uri = UriComponentsBuilder.fromUriString("https://github.com/login/oauth/authorize")
                                      .queryParam("client_id", System.getenv("GITHUB_CLIENT_ID"))
                                      .queryParam("scope", "user")
                                      .build()
                                      .toUri();
        headers.setLocation(uri);
        return new ResponseEntity<>("redirect", headers, HttpStatus.SEE_OTHER);
    }

    @GetMapping("/oauth")
    public ResponseEntity<String> oauthAuthentication(@RequestParam("code") String code, HttpServletResponse response) {
        String accessToken = gitHubOAuthService.getGitHubTokenToCode(code).getAccessToken();
        log.debug("AccessToken: {}", accessToken);

        User user = gitHubOAuthService.insertUserInfo(accessToken);
        log.debug("DB에 저장된 User 정보: {}", user);

        String jws = jwtService.createJws("user", user);
        log.debug("jws: {}", jws);

        Cookie cookie = new Cookie("jwt", jws);
        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        cookie.setPath("/");

        response.addCookie(cookie);
        response.setHeader("Location", "http://localhost:8080/login/with-github");
        return new ResponseEntity<>("redirect", HttpStatus.FOUND);
    }

}