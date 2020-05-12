package kr.codesquad.baseball.business.domain.player.pitcher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Slf4j
@Repository
public class PitcherDao {

    private static final String SELECT_PITCHER_BY_ID = "\nSELECT p.id, p.name\n  FROM pitcher p\n WHERE id = :id";
    private static final String SELECT_PITCHER_BY_TEAM_ID = "\nSELECT p.id, p.name\n  FROM pitcher p\n WHERE team_id = :team_id";

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Pitcher> pitcherMapper;

    public PitcherDao(DataSource dataSource, RowMapper<Pitcher> pitcherMapper) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.pitcherMapper = pitcherMapper;
    }

    public Pitcher findById(int id) {
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject(SELECT_PITCHER_BY_ID, parameters, pitcherMapper);
    }

    public Pitcher findByTeamId(int teamId) {
        SqlParameterSource parameters = new MapSqlParameterSource("team_id", teamId);
        return jdbcTemplate.queryForObject(SELECT_PITCHER_BY_TEAM_ID, parameters, pitcherMapper);
    }
}
