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
import java.util.Optional;

@Slf4j
@Repository
public class UserDao {

    private static final String UPDATE_USER = "\nUPDATE user\n SET nickname = :nickname,\n email = :email,\n github_token = :github_token\n WHERE user_id = :user_id;";
    private static final String SELECT_USER_BY_USER_ID = "\nSELECT u.user_id, u.nickname, u.email, u.github_token\n  FROM user u\n WHERE u.user_id = :user_id;";
    private static final String COUNT_USER_BY_USER_ID = "\nSELECT COUNT(*)\n  FROM user u\n WHERE u.user_id = :user_id;";

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
        return jdbcTemplate.update(UPDATE_USER, getParamMap(user));
    }

    public Optional<User> findByUserId(User user) {
        SqlParameterSource parameters = new MapSqlParameterSource("user_id", user.getUserId());
        return jdbcTemplate.query(SELECT_USER_BY_USER_ID, parameters, (rs, rowNum) ->
                User.builder()
                    .userId(rs.getString("user_id"))
                    .nickname(rs.getString("nickname"))
                    .email(rs.getString("email"))
                    .githubToken(rs.getString("github_token"))
                    .build()
               ).stream().findFirst();
    }

    public Integer countByUserId(User user) {
        SqlParameterSource parameters = new MapSqlParameterSource("user_id", user.getUserId());
        return jdbcTemplate.queryForObject(COUNT_USER_BY_USER_ID, parameters, Integer.class);
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
