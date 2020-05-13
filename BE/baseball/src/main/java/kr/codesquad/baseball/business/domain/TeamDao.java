package kr.codesquad.baseball.business.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TeamDao {

    private static final String SELECT_TEAM_BY_ID = "\nSELECT t.id, t.name, t.last_batter\n  FROM team t\n WHERE id = :id";

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

    public Team findById(int id) {
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject(SELECT_TEAM_BY_ID, parameters, (rs, rowNum) ->
                Team.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .lastBatter(rs.getInt("last_batter"))
                    .build());
    }
}
