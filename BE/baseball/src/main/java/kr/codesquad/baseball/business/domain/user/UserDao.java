package kr.codesquad.baseball.business.domain.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class UserDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("user");
    }

    public int insertUserData(User user) {
        return jdbcInsert.execute(getParamMap(user));
    }

    public int updateUserData(User user) {
        String updateQuery = "\nUPDATE user\n SET nickname = :nickname,\n email = :email,\n github_token = :github_token\n WHERE user_id = :user_id;";
        return jdbcTemplate.update(updateQuery, getParamMap(user));
    }

    public User findByUserId(User user) {
        String findQuery = "\nSELECT u.user_id, u.nickname, u.email, u.github_token\n  FROM user u\n WHERE u.user_id = :user_id;";
        SqlParameterSource parameters = new MapSqlParameterSource("user_id", user.getUserId());
        return jdbcTemplate.queryForObject(findQuery, parameters, (rs, rowNum) ->
                User.builder()
                    .userId(rs.getString("user_id"))
                    .nickname(rs.getString("nickname"))
                    .email(rs.getString("email"))
                    .githubToken(rs.getString("github_token"))
                    .build());
    }

    public Integer countByUserId(User user) {
        String findQuery = "\nSELECT COUNT(*)\n  FROM user u\n WHERE u.user_id = :user_id;";
        SqlParameterSource parameters = new MapSqlParameterSource("user_id", user.getUserId());
        return jdbcTemplate.queryForObject(findQuery, parameters, Integer.class);
    }

    private Map<String, Object> getParamMap(User user) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", user.getUserId());
        paramMap.put("nickname", user.getNickname());
        paramMap.put("email", user.getEmail());
        paramMap.put("github_token", user.getGithubToken());
        return paramMap;
    }
}
