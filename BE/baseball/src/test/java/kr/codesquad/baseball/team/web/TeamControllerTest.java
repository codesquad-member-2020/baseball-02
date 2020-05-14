package kr.codesquad.baseball.team.web;

import kr.codesquad.baseball.team.business.TeamService;
import kr.codesquad.baseball.team.data.Team;
import kr.codesquad.baseball.team.data.TeamDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = TeamController.class)
class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @MockBean
    private TeamDAO teamDAO;

    @Test
    public void 팀_목록_조회() throws Exception {
        // given
        Team team0 = new Team(1, "team1");
        Team team1 = new Team(2, "team2");
        Team team2 = new Team(3, "team3");
        Team team3 = new Team(4, "team4");

        given(teamService.selectAll()).willReturn(Arrays.asList(team0, team1, team2, team3));

        // then
        mockMvc.perform(get("/team/list"))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.[0]").isNotEmpty())
                .andExpect(jsonPath("$.[0].id", is(team0.getId())));
    }
}
