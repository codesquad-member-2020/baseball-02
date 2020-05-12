package kr.codesquad.baseball.business.domain.player.batter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class BatterDao {

    private static final String SELECT_BATTER_BY_ID = "\nSELECT b.id, b.name, b.back_number, b.batting_number, b.hit_rate\n  FROM batter b\n WHERE b.id = :id";
    private static final String SELECT_BATTERS_BY_TEAM_ID = "\nSELECT b.id, b.name, b.back_number, b.batting_number, b.hit_rate\n  FROM batter b\n WHERE b.team_id = :team_id\n ORDER BY b.batting_number";

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Batter> batterMapper;

    public BatterDao(DataSource dataSource, RowMapper<Batter> batterMapper) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.batterMapper = batterMapper;
    }

    public Batter findByBatterId(int id) {
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject(SELECT_BATTER_BY_ID, parameters, batterMapper);
    }

    public List<Batter> findByTeamId(int teamId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("team_id", teamId);
        return jdbcTemplate.query(SELECT_BATTERS_BY_TEAM_ID, parameterSource, batterMapper);
    }
}
