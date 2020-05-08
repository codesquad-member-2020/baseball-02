# Backend team

INSERT INTO baseball.team
    (id, name)
VALUES
    (1, 'Backend');

INSERT INTO baseball.pitcher
    (id, name, team_id)
VALUES
    (1, 'Dion', 1);

INSERT INTO baseball.batter
    (id, name, batting_number, hit_rate, team_id)
VALUES
    (1, 'XP', 1, 555, 1),
    (2, 'Jack', 2, 555, 1),
    (3, 'Jay', 3, 555, 1),
    (4, 'David', 4, 555, 1),
    (5, 'Ever', 5, 555, 1),
    (6, 'Sigrid', 6, 555, 1),
    (7, 'Mocha', 7, 555, 1),
    (8, 'Alex', 8, 555, 1),
    (9, 'Han', 9, 555, 1);


# Front team

INSERT INTO baseball.team
    (id, name)
VALUE
    (2, 'Frontend');

INSERT INTO baseball.pitcher
    (id, name, team_id)
VALUES
    (2, 'Won', 2);

INSERT INTO baseball.batter
    (id, name, batting_number, hit_rate, team_id)
VALUES
    (10, 'Baekco', 1, 333, 2),
    (11, 'Reese', 2, 333, 2),
    (12, 'Sally', 3, 333, 2),
    (13, 'Joy', 4, 333, 2),
    (14, 'Huey', 5, 333, 2),
    (15, 'Ellin', 6, 333, 2),
    (16, 'Lime', 7, 333, 2),
    (17, 'Zello', 8, 333, 2),
    (18, 'Hoo', 9, 333, 2);


# iOS team

INSERT INTO baseball.team
    (id, name)
VALUES
    (3, 'iOS');

INSERT INTO baseball.pitcher
    (id, name, team_id)
VALUES
    (3, 'Jini', 3);

INSERT INTO baseball.batter
    (id, name, batting_number, hit_rate, team_id)
VALUES
    (19, 'Cory', 1, 333, 3),
    (20, '모스', 2, 333, 3),
    (21, 'Olaf', 3, 333, 3),
    (22, 'Lena', 4, 333, 3),
    (23, 'Jason', 5, 333, 3),
    (24, '또치', 6, 333, 3),
    (25, 'Delma', 7, 333, 3),
    (26, 'GangWoon', 8, 333, 3),
    (27, 'Lin', 9, 333, 3);


# master team

INSERT INTO baseball.team
    (id, name)
VALUES
    (4, 'master');

INSERT INTO baseball.pitcher
    (id, name, team_id)
VALUES
    (4, 'JK', 4);

INSERT INTO baseball.batter
    (id, name, batting_number, hit_rate, team_id)
VALUES
    (28, 'Crong', 1, 333, 4),
    (29, 'Honux', 2, 333, 4),
    (30, 'Yagom', 3, 333, 4),
    (31, 'Sarah', 4, 333, 4),
    (32, 'Head', 5, 333, 4),
    (33, '호글', 6, 333, 4),
    (34, 'Brian', 7, 333, 4),
    (35, '자바지기', 8, 333, 4),
    (36, '붱이', 9, 333, 4);
