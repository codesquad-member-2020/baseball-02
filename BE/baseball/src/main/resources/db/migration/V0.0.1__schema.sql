CREATE SCHEMA IF NOT EXISTS `baseball` DEFAULT CHARACTER SET utf8;
USE `baseball`;

CREATE TABLE IF NOT EXISTS `baseball`.`user`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `account`  VARCHAR(45) NOT NULL,
    `nickname` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `account_UNIQUE` (`account` ASC)
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `baseball`.`team`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `baseball`.`player`
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(45) NOT NULL,
    `hit_rate`    FLOAT       NULL,
    `back_number` INT         NOT NULL,
    `team_id`     INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_player_team_idx` (`team_id` ASC),
    CONSTRAINT `fk_player_team`
        FOREIGN KEY (`team_id`)
            REFERENCES `baseball`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `baseball`.`game`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `status`    VARCHAR(45) NOT NULL,
    `home_team` INT         NOT NULL,
    `away_team` INT         NOT NULL,
    `home_user` INT         NOT NULL,
    `away_user` INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_game_team1_idx` (`home_team` ASC),
    INDEX `fk_game_team2_idx` (`away_team` ASC),
    INDEX `fk_game_user1_idx` (`home_user` ASC),
    INDEX `fk_game_user2_idx` (`away_user` ASC),
    CONSTRAINT `fk_game_team1`
        FOREIGN KEY (`home_team`)
            REFERENCES `baseball`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_game_team2`
        FOREIGN KEY (`away_team`)
            REFERENCES `baseball`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_game_user1`
        FOREIGN KEY (`home_user`)
            REFERENCES `baseball`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_game_user2`
        FOREIGN KEY (`away_user`)
            REFERENCES `baseball`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `baseball`.`inning`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `inning_number` INT         NOT NULL,
    `is_last`       VARCHAR(45) NOT NULL,
    `strike_count`  INT         NOT NULL DEFAULT 0,
    `ball_count`    INT         NOT NULL DEFAULT 0,
    `out_count`     INT         NOT NULL DEFAULT 0,
    `score_count`   INT         NOT NULL DEFAULT 0,
    `game_id`       INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_inning_game1_idx` (`game_id` ASC),
    CONSTRAINT `fk_inning_game1`
        FOREIGN KEY (`game_id`)
            REFERENCES `baseball`.`game` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `baseball`.`game_record`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `action`  VARCHAR(45) NOT NULL,
    `game_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_game_record_game1_idx` (`game_id` ASC),
    CONSTRAINT `fk_game_record_game1`
        FOREIGN KEY (`game_id`)
            REFERENCES `baseball`.`game` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;
