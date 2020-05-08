package kr.codesquad.baseball.business.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TeamDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String SELECT_ALL = "SELECT id, name, last_batter FROM team";

    public List<Team> selectAll() {
        return jdbcTemplate.query(SELECT_ALL, (rs, rowNum) ->
                Team.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .lastBatter(rs.getInt("last_batter"))
                        .build()
        );
    }
}
