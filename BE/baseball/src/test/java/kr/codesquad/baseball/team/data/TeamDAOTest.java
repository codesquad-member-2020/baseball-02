package kr.codesquad.baseball.team.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = NONE)
class TeamDAOTest {

    @Autowired
    private TeamDAO teamDAO;

    @Test
    public void 팀_목록_조회_쿼리_테스트() {
        // given

        // when
        List<Team> teams = teamDAO.selectAll();
        // then
        assertThat(teams.size()).isGreaterThan(3);
        assertThat(teams.get(0).getId()).isNotNull();
        assertThat(teams.get(0).getName()).isNotNull();
        assertThat(teams.get(1).getId()).isNotNull();
        assertThat(teams.get(1).getName()).isNotNull();
        assertThat(teams.get(2).getId()).isNotNull();
        assertThat(teams.get(2).getName()).isNotNull();
        assertThat(teams.get(3).getId()).isNotNull();
        assertThat(teams.get(3).getName()).isNotNull();
    }

}
