import React from "react";
import ScoreBoard from "Components/ScoreBoard.jsx";
import CurrentPlayers from "Components/CurrentPlayers.jsx";
import Stadium from "Components/Stadium.jsx";
import Record from "Components/Record.jsx";
import { GridContainer, Box } from "Styles/Match";

const Match = () => {
	return (
		<div>
			<GridContainer>
				<Box>
					<ScoreBoard />
				</Box>
				<Box>
					<CurrentPlayers />
				</Box>
				<Box>
					<Stadium />
				</Box>
				<Box>
					<Record />
				</Box>
			</GridContainer>
		</div>
	);
};

export default Match;
