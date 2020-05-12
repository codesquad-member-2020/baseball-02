import React from "react";
import { PLAYER_RECORD } from "Utils/const";
import {
	Container,
	TitleContainer,
	Back,
	Title,
	TableContainer,
	STable,
	SCaption,
	STr,
	STd,
} from "Styles/PlayerRecord";

const Table = ({ props }) => {
	const { name, players } = props;

	const totals = {
		totals: "Totals",
		atBat: 0,
		hit: 0,
		out: 0,
	};

	const makeRows = (player, i) => {
		const cell = [];
		for (let prop in player) {
			cell.push(<STd key={prop + i}>{player[prop]}</STd>);
			if (prop !== "name") totals[prop] += player[prop];
		}
		cell.push(<STd key={"average" + i}>{(player.hit / player.atBat).toFixed(3)}</STd>);
		return <tr key={`row${i}`}>{cell}</tr>;
	};

	const addTotalsRow = () => {
		const total = [];

		for (let prop in totals) {
			total.push(<STd key={prop}>{totals[prop]}</STd>);
		}
		totals.atBat = 0;
		totals.hit = 0;
		totals.out = 0;
		return <tr key="totals">{total}</tr>;
	};

	const rows = players.map(makeRows);
	rows.push(addTotalsRow());

	return (
		<STable>
			<SCaption>{name}</SCaption>
			<thead>
				<STr>
					<th>타자</th>
					<th>타석</th>
					<th>안타</th>
					<th>아웃</th>
					<th>평균</th>
				</STr>
			</thead>
			<tbody className={name}>{rows}</tbody>
		</STable>
	);
};

const PlayerRecord = () => {
	return (
		<Container>
			<TitleContainer>
				<Back>{"<"}</Back>
				<Title>Player Record</Title>
			</TitleContainer>
			<TableContainer>
				<Table props={PLAYER_RECORD.teams.home} />
				<Table props={PLAYER_RECORD.teams.away} />
			</TableContainer>
		</Container>
	);
};

export default PlayerRecord;
