package kr.codesquad.baseball.business.domain.inning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class InningDao {

    // language=SQL
    private static final String SELECT_INNING_LIST = "\nSELECT i.id, i.inning_number, IF(i.is_first, 'TRUE', 'FALSE') AS is_first, i.strike_count, i.ball_count, i.out_count, i.score\n  FROM inning i\n WHERE i.game_id = :game_id\n ORDER BY i.inning_number, i.is_first DESC";

    // language=SQL
    private static final String SELECT_LAST_INNING = "\nSELECT i.id, i.inning_number, IF(i.is_first, 'TRUE', 'FALSE') AS is_first, i.strike_count, i.ball_count, i.out_count, i.score\n  FROM inning i\n WHERE i.game_id = :game_id\n ORDER BY i.id DESC LIMIT 1";

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Inning> inningMapper;

    public InningDao(DataSource dataSource, RowMapper<Inning> inningMapper) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.inningMapper = inningMapper;
    }

    public List<Inning> findInningListByGameId(int gameId) {
        SqlParameterSource parameters = new MapSqlParameterSource("game_id", gameId);
        return jdbcTemplate.query(SELECT_INNING_LIST, parameters, inningMapper);
    }

    public Optional<Inning> findLastInningByGameId(int gameId) {
        SqlParameterSource parameters = new MapSqlParameterSource("game_id", gameId);
        return jdbcTemplate.query(SELECT_LAST_INNING, parameters, inningMapper).stream().findFirst();
    }
}
