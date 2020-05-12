package kr.codesquad.baseball.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ToString
public class GameDto {

    private int id;
    private LocalDateTime playDate;
    private TeamDto home;
    private TeamDto away;
    private List<InningDto> innings;
    private InningDto lastInning;

    public boolean isAttackTeam(int teamId) {
        // 초면 Away가 공격팀, 말이면 Home이 공격팀.
        if (this.lastInning.getIsFirst()) {
            return this.away.getId() == teamId;
        }
        return this.home.getId() == teamId;
    }
}
