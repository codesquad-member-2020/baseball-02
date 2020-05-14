package kr.codesquad.baseball.common.config;

import kr.codesquad.baseball.business.domain.inning.Inning;
import kr.codesquad.baseball.business.domain.player.batter.Batter;
import kr.codesquad.baseball.business.domain.player.pitcher.Pitcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class RowMapperConfig {

    @Bean
    public RowMapper<Batter> batterMapper() {
        return (rs, rowNum) -> Batter.builder()
                                     .id(rs.getInt("id"))
                                     .name(rs.getString("name"))
                                     .backNumber(rs.getInt("back_number"))
                                     .battingNumber(rs.getInt("batting_number"))
                                     .hitRate(rs.getInt("hit_rate"))
                                     .build();
    }

    @Bean
    public RowMapper<Pitcher> pitcherMapper() {
        return (rs, rowNum) -> Pitcher.builder()
                                      .id(rs.getInt("id"))
                                      .name(rs.getString("name"))
                                      .backNumber(rs.getInt("back_number"))
                                      .build();
    }

    @Bean
    public RowMapper<Inning> inningMapper() {
        return (rs, rowNum) -> Inning.builder()
                                     .id(rs.getInt("id"))
                                     .inningNumber(rs.getInt("inning_number"))
                                     .isFirst(rs.getBoolean("is_first"))
                                     .strikeCount(rs.getInt("strike_count"))
                                     .ballCount(rs.getInt("ball_count"))
                                     .outCount(rs.getInt("out_count"))
                                     .score(rs.getInt("score"))
                                     .build();
    }
}
