import React from "react";
import { Link } from "react-router-dom";
import { PATH } from "Utils/const";

const Match = () => {
	return (
		<>
			<h1>Match</h1>
			<button>
				<Link to={PATH.PLAYER_RECORD}>Player Record ></Link>
			</button>
		</>
	);
};

export default Match;
