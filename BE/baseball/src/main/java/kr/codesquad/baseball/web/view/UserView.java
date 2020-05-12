package kr.codesquad.baseball.web.view;

import kr.codesquad.baseball.business.domain.user.User;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class UserView {

    private String userId;
    private String nickname;
    private String email;

    public static UserView of(User user) {
        return UserView.builder().userId(user.getUserId()).nickname(user.getNickname()).email(user.getEmail()).build();
    }

    public static UserView of(Map<String, String> userMap) {
        return new UserView(userMap);
    }

    private UserView(Map<String, String> userMap) {
        this.userId = userMap.get("userId");
        this.nickname = userMap.get("nickname");
        this.email = userMap.get("email");
    }
}
