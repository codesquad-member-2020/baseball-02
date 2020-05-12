# Backend team

INSERT INTO baseball.team
    (id, name)
VALUES
    (1, 'Backend');

INSERT INTO baseball.pitcher
    (id, name, back_number, team_id)
VALUES
    (1, 'Dion', 1, 1);

INSERT INTO baseball.batter
    (id, name, back_number, batting_number, hit_rate, team_id)
VALUES
    (1, 'XP', 2, 1, 555, 1),
    (2, 'Jack', 3, 2, 555, 1),
    (3, 'Jay', 4, 3, 555, 1),
    (4, 'David', 5, 4, 555, 1),
    (5, 'Ever', 6, 5, 555, 1),
    (6, 'Sigrid', 7, 6, 555, 1),
    (7, 'Mocha', 8, 7, 555, 1),
    (8, 'Alex', 9, 8, 555, 1),
    (9, 'Han', 10, 9, 555, 1);


# Front team

INSERT INTO baseball.team
    (id, name)
VALUE
    (2, 'Frontend');

INSERT INTO baseball.pitcher
    (id, name, back_number, team_id)
VALUES
    (2, 'Won', 20, 2);

INSERT INTO baseball.batter
    (id, name, back_number, batting_number, hit_rate, team_id)
VALUES
    (10, 'Baekco', 21, 1, 333, 2),
    (11, 'Reese', 22, 2, 333, 2),
    (12, 'Sally', 23, 3, 333, 2),
    (13, 'Joy', 24, 4, 333, 2),
    (14, 'Huey', 25, 5, 333, 2),
    (15, 'Ellin', 26, 6, 333, 2),
    (16, 'Lime', 27, 7, 333, 2),
    (17, 'Zello', 28, 8, 333, 2),
    (18, 'Hoo', 29, 9, 333, 2);


# iOS team

INSERT INTO baseball.team
    (id, name)
VALUES
    (3, 'iOS');

INSERT INTO baseball.pitcher
    (id, name, back_number, team_id)
VALUES
    (3, 'Jinie', 30, 3);

INSERT INTO baseball.batter
    (id, name, back_number, batting_number, hit_rate, team_id)
VALUES
    (19, 'Cory', 31, 1, 333, 3),
    (20, '모스', 32, 2, 333, 3),
    (21, 'Olaf', 33, 3, 333, 3),
    (22, 'Lena', 34, 4, 333, 3),
    (23, 'Jason', 35, 5, 333, 3),
    (24, '또치', 36, 6, 333, 3),
    (25, 'Delma', 37, 7, 333, 3),
    (26, 'GangWoon', 38, 8, 333, 3),
    (27, 'Lin', 39, 9, 333, 3);


# master team

INSERT INTO baseball.team
    (id, name)
VALUES
    (4, 'master');

INSERT INTO baseball.pitcher
    (id, name, back_number, team_id)
VALUES
    (4, 'JK', 40, 4);

INSERT INTO baseball.batter
    (id, name, back_number, batting_number, hit_rate, team_id)
VALUES
    (28, 'Crong', 41, 1, 333, 4),
    (29, 'Honux', 42, 2, 333, 4),
    (30, 'Yagom', 43, 3, 333, 4),
    (31, 'Sarah', 44, 4, 333, 4),
    (32, 'Head', 45, 5, 333, 4),
    (33, '호글', 46, 6, 333, 4),
    (34, 'Brian', 47, 7, 333, 4),
    (35, '자바지기', 48, 8, 333, 4),
    (36, '붱이', 49, 9, 333, 4);
