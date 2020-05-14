package kr.codesquad.baseball.team.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static kr.codesquad.baseball.sql.SQLKt.SELECT_TEAM_ALL;

@Slf4j
@Repository
public class TeamDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public TeamDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Team> selectAll() {
        return jdbcTemplate.query(SELECT_TEAM_ALL, (rs, rowNum) ->
                new Team(rs.getInt("id"), rs.getString("name")));
    }
}
