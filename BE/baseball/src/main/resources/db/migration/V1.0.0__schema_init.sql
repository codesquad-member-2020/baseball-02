CREATE TABLE  baseball.team (
      id INT NOT NULL AUTO_INCREMENT,
      name VARCHAR(45) NOT NULL,
      PRIMARY KEY (id))
ENGINE = InnoDB;


CREATE TABLE  baseball.game (
      id INT NOT NULL AUTO_INCREMENT,
      date DATETIME NOT NULL,
      home INT NOT NULL,
      away INT NOT NULL,
      PRIMARY KEY (id, date),
      INDEX fk_game_team_idx (home ASC),
      INDEX fk_game_team1_idx (away ASC),
      CONSTRAINT fk_game_team
        FOREIGN KEY (home)
        REFERENCES baseball.team (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT fk_game_team1
        FOREIGN KEY (away)
        REFERENCES baseball.team (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE  baseball.pitcher (
      id INT NOT NULL AUTO_INCREMENT,
      name VARCHAR(45) NOT NULL,
      team_id INT NOT NULL,
      PRIMARY KEY (id),
      INDEX fk_pitcher_team1_idx (team_id ASC),
      CONSTRAINT fk_pitcher_team1
        FOREIGN KEY (team_id)
        REFERENCES baseball.team (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE  baseball.batter (
      id INT NOT NULL AUTO_INCREMENT,
      name VARCHAR(45) NOT NULL,
      team_id INT NOT NULL,
      PRIMARY KEY (id),
      INDEX fk_batter_team1_idx (team_id ASC),
      CONSTRAINT fk_batter_team1
        FOREIGN KEY (team_id)
        REFERENCES baseball.team (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE  baseball.palyer_record (
      id INT NOT NULL AUTO_INCREMENT,
      at_bat VARCHAR(45) NOT NULL,
      hit VARCHAR(45) NOT NULL,
      batter_id INT NOT NULL,
      game_id INT NOT NULL,
      game_date DATETIME NOT NULL,
      PRIMARY KEY (id),
      INDEX fk_palyer_record_batter1_idx (batter_id ASC),
      INDEX fk_palyer_record_game1_idx (game_id ASC, game_date ASC),
      CONSTRAINT fk_palyer_record_batter1
        FOREIGN KEY (batter_id)
        REFERENCES baseball.batter (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT fk_palyer_record_game1
        FOREIGN KEY (game_id , game_date)
        REFERENCES baseball.game (id , date)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE  baseball.inning (
      id INT NOT NULL,
      number VARCHAR(45) NOT NULL,
      halves ENUM('FIRST', 'SECOND') NOT NULL,
      strike_count INT NOT NULL,
      ball_count INT NOT NULL,
      out_count INT NOT NULL,
      score INT NOT NULL,
      game_id INT NOT NULL,
      game_date DATETIME NOT NULL,
      PRIMARY KEY (id),
      INDEX fk_inning_game1_idx (game_id ASC, game_date ASC),
      CONSTRAINT fk_inning_game1
        FOREIGN KEY (game_id , game_date)
        REFERENCES baseball.game (id , date)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE  baseball.inning_record (
      id INT NOT NULL AUTO_INCREMENT,
      action VARCHAR(45) NOT NULL,
      inning_id INT NOT NULL,
      batter_id INT NOT NULL,
      PRIMARY KEY (id),
      INDEX fk_inning_record_inning1_idx (inning_id ASC),
      INDEX fk_inning_record_batter1_idx (batter_id ASC),
      CONSTRAINT fk_inning_record_inning1
        FOREIGN KEY (inning_id)
        REFERENCES baseball.inning (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT fk_inning_record_batter1
        FOREIGN KEY (batter_id)
        REFERENCES baseball.batter (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
ENGINE = InnoDB;
