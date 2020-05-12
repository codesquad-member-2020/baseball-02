package kr.codesquad.baseball.business.domain.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
@Repository
public class GameDao {

    private static final String SELECT_GAME_BY_ID = "\nSELECT g.id, g.play_date, g.home, g.away\n  FROM game g\n WHERE g.id = :id";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public GameDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Optional<Game> findById(int id) {
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return jdbcTemplate.query(SELECT_GAME_BY_ID, parameters, (rs, rowNum) ->
                Game.builder()
                    .id(rs.getInt("id"))
                    .playDate(LocalDateTime.parse(rs.getString("play_date"), formatter))
                    .home(rs.getInt("home"))
                    .away(rs.getInt("away"))
                    .build())
               .stream().findFirst();
    }
}
