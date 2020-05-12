export const PATH = {
	HOME: "/",
	TEAM_CHOICE: "/team-choice",
	MATCH: "/match",
	PLAYER_RECORD: "/player-record",
};

export const TEAMS = [
	{ id: 1, name: "Captain" },
	{ id: 2, name: "Marvel" },
	{ id: 3, name: "Twins" },
	{ id: 4, name: "Tigers" },
	{ id: 5, name: "Rockets" },
	{ id: 6, name: "Dodgers" },
];

export const GAME_START = {
	home: {
		id: 1,
		name: "Captain",
		isMyTeam: true,
	},
	away: {
		id: 2,
		name: "Marvels",
		isMyTeam: false,
	},
	scores: [
		{ inning: 1, home: 1, away: 1 },
		{ inning: 2, home: 0, away: 1 },
		{ inning: 3, home: 2, away: 0 },
		{ inning: 4, home: 0, away: 1 },
		{ inning: 5, home: 1, away: 0 },
		{ inning: 6, home: 3, away: 3 },
		{ inning: 7, home: 0, away: 1 },
		{ inning: 8, home: 1, away: 2 },
		{ inning: 9, home: 2, away: 1 },
	],
	inningInfo: {
		inning: 2,
		half: "first",
		attackOrDefense: "defense",
	},
	ballCount: {
		strike: 2,
		ball: 3,
		out: 2,
	},
	currentPlayers: {
		pitcher: { name: "최동원", number: "39" },
		batter: { name: "류현진", number: 7, atBat: 1, hit: 0 },
	},
};

export const PLAYER_RECORD = {
	teams: {
		home: {
			name: "Captain",
			players: [
				{
					name: "김광진",
					atBat: 1,
					hit: 0,
					out: 2,
				},
				{
					name: "류현진",
					atBat: 1,
					hit: 2,
					out: 0,
				},
				{
					name: "추진수",
					atBat: 2,
					hit: 1,
					out: 1,
				},
				{
					name: "한양범",
					atBat: 4,
					hit: 0,
					out: 1,
				},
				{
					name: "김진수",
					atBat: 1,
					hit: 1,
					out: 0,
				},
				{
					name: "최동원",
					atBat: 1,
					hit: 0,
					out: 0,
				},
				{
					name: "이동규",
					atBat: 1,
					hit: 1,
					out: 0,
				},
				{
					name: "이용대",
					atBat: 1,
					hit: 1,
					out: 1,
				},
				{
					name: "박영권",
					atBat: 1,
					hit: 0,
					out: 1,
				},
			],
		},
		away: {
			name: "Marvels",
			players: [
				{
					name: "김광진",
					atBat: 1,
					hit: 0,
					out: 1,
				},
				{
					name: "류현진",
					atBat: 1,
					hit: 2,
					out: 0,
				},
				{
					name: "추진수",
					atBat: 2,
					hit: 1,
					out: 1,
				},
				{
					name: "한양범",
					atBat: 4,
					hit: 0,
					out: 1,
				},
				{
					name: "김진수",
					atBat: 1,
					hit: 1,
					out: 0,
				},
				{
					name: "최동원",
					atBat: 1,
					hit: 0,
					out: 0,
				},
				{
					name: "이동규",
					atBat: 1,
					hit: 1,
					out: 0,
				},
				{
					name: "이용대",
					atBat: 1,
					hit: 1,
					out: 1,
				},
				{
					name: "박영권",
					atBat: 1,
					hit: 0,
					out: 1,
				},
			],
		},
	},
};
