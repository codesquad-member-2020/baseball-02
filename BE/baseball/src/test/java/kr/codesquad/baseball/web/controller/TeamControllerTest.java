package kr.codesquad.baseball.web.controller;

import kr.codesquad.baseball.business.domain.Team;
import kr.codesquad.baseball.business.service.TeamService;
import kr.codesquad.baseball.web.dto.SimpleTeamDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TeamController.class)
class TeamControllerTest {

    private Logger log = LoggerFactory.getLogger(TeamControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @Test
    public void 팀_목록_조회() throws Exception {

        // given
        Team team1 = new Team(1, "Backend", 1);
        Team team2 = new Team(2, "Frontend", 1);
        Team team3 = new Team(3, "iOS", 1);
        Team team4 = new Team(4, "Masters", 1);

        List<Team> teams = Arrays.asList(team1, team2, team3, team4);
        given(teamService.findAll()).willReturn(teams.stream().map(SimpleTeamDto::new).collect(Collectors.toList()));

        // when && then
        mockMvc.perform(get("/teams"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(teams.size())))
                .andExpect(jsonPath("$[0].id", is(teams.get(0).getId())))
                .andExpect(jsonPath("$[2].name", is(teams.get(2).getName())))
                .andExpect(jsonPath("$[3].name", is(teams.get(3).getName())));
    }

}
