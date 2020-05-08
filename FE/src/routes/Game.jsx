import React from "react";
import { Link } from "react-router-dom";
import { PATH } from "Utils/const";

const Game = () => {
	return (
		<>
			<h1>Game</h1>
			<button>
				<Link to={PATH.PLAYER_RECORD}>Player Record ></Link>
			</button>
		</>
	);
};

export default Game;
