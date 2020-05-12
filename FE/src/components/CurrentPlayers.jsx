import React from "react";
import { GAME_START } from "Utils/const";
import { Container, PlayerType, PlayerInfo } from "Styles/CurrentPlayers";

const CurrentPlayers = () => {
	const {
		currentPlayers: { pitcher, batter },
	} = GAME_START;

	return (
		<Container>
			<PlayerType>투수</PlayerType>
			<PlayerInfo>{`${pitcher.name} #${pitcher.number}`}</PlayerInfo>
			<PlayerType>타자</PlayerType>
			<PlayerInfo>{`${batter.name} #${batter.number} ${batter.atBat}타석 ${batter.hit}안타`}</PlayerInfo>
		</Container>
	);
};

export default CurrentPlayers;
